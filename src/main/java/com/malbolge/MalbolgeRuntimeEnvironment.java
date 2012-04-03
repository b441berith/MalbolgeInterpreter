package com.malbolge;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.malbolge.operations.CrazyOperation;
import com.malbolge.operations.MalbolgeOperation;
import com.malbolge.operations.MalbolgeOperationCodes;
import com.malbolge.operations.MalbolgeOperationEncryptor;
import com.malbolge.operations.MalbolgeOperationFactory;
import com.malbolge.vm.MalbolgeVMRegister;
import com.processor.RuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 15:44
 */
public class MalbolgeRuntimeEnvironment implements RuntimeEnvironment<MalbolgeProgram> {
    /*
     * Virtual machine registers.
     * Syntax for index d:
     * [d] - value in d register. d - memory pointer
     */
    private final MalbolgeVMRegister aRegister;
    private final MalbolgeVMRegister cRegister; //special register - points to the current instruction
    private final MalbolgeVMRegister dRegister;

    private final InputStream inputStream;
    private final OutputStream outputStream;

    private final List<Integer> memory;

    /**
     * The virtual machine has 59049 (310) memory locations that can each hold a ten-digit ternary number
     */
    public static final int DEFAULT_MEMORY_SIZE = 59049;

    /*
     * Each memory location has an address from 0 to 59048 and can hold a value from 0 to 59048. Incrementing past this limit wraps back to zero.
     */
    public static final int MIN_MEMORY_VALUE = 0;
    public static final int MAX_MEMORY_VALUE = 59048;

    public MalbolgeRuntimeEnvironment(InputStream in, OutputStream out, MalbolgeProgram program) {
        this.inputStream = in;
        this.outputStream = out;
        this.memory = new ArrayList<Integer>(DEFAULT_MEMORY_SIZE);
        //Init memory
        int operationCount = 0;
        if (program.getOperations() != null) {
            operationCount = program.getOperations().size();
        }
        //Before a Malbolge program starts, the first part of memory is filled with the program
        for (int i = 0; i < operationCount; i++) {
            memory.set(i, (int) MalbolgeOperationFactory.getOperatonCode(program.getOperations().get(i)));
        }
        //The rest of memory is filled by using the crazy operation on the previous two addresses ([m] = crz [m - 2], [m - 1])
        for (int i = operationCount; i < DEFAULT_MEMORY_SIZE; i++) {
            int last1, last2;
            if (i == 0) {
                last1 = 0;
                last2 = 0;
            } else if (i == 1) {
                last1 = 0;
                last2 = memory.get(0);
            } else {
                last1 = memory.get(i - 2);
                last2 = memory.get(i - 1);
            }
            int m = CrazyOperation.getCrazyValue(last1, last2);
            memory.set(i, m);
        }
        //Init VM registers
        this.aRegister = new MalbolgeVMRegister();
        this.cRegister = new MalbolgeVMRegister();
        this.dRegister = new MalbolgeVMRegister();
    }

    public MalbolgeVMRegister getARegister() {
        return aRegister;
    }

    public MalbolgeVMRegister getCRegister() {
        return cRegister;
    }

    public MalbolgeVMRegister getDRegister() {
        return dRegister;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void runProgram() {
        boolean programRunning = true;
        while (programRunning) {
            byte operationCode = getNextOperationCode();
            if (!MalbolgeOperationFactory.operationExists(operationCode)) {
                //Any other value does the same as 68: nothing.
                operationCode = 68;
            }
            MalbolgeOperation operation = MalbolgeOperationFactory.createOperation(operationCode);
            if (MalbolgeOperationCodes.END_OF_PROGRAM == MalbolgeOperationFactory.getOperatonCode(operation)) {
                programRunning = false;
            } else {
                operation.execute(this);
                //After an instruction is executed, the value at [c] (without anything added to it) will be replaced with itself mod 94.
                int cValue = cRegister.getValue() % 94;
                //Then, the result is encrypted
                int cValueEncrypted = MalbolgeOperationEncryptor.encrypt(cValue);
                cRegister.setValue(cValueEncrypted);
            }
        }
    }

    private byte getNextOperationCode() {
        int c = cRegister.getMemoryPointer();
        int cValue = cRegister.getValue();
        return (byte) ((cValue + c) % 94);
    }
}
