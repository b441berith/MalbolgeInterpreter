package com.malbolge;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.malbolge.operations.MalbolgeOperation;
import com.malbolge.vm.MalbolgeVMRegister;
import com.processor.RuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 15:44
 */
public class MalbolgeRuntimeEnvironment implements RuntimeEnvironment<MalbolgeProgram>{
    /*
     * Virtual machine registers.
     * Syntax for index d:
     * [d] - value in d register. d - memory pointer
     */
    private MalbolgeVMRegister aRegister;
    private MalbolgeVMRegister cRegister; //special register - points to the current instruction
    private MalbolgeVMRegister dRegister;

    private InputStream inputStream;
    private OutputStream outputStream;
    private List<MalbolgeOperation> machineOperations;

    private List<Integer> memory;

    public MalbolgeRuntimeEnvironment(InputStream in, OutputStream out, MalbolgeProgram program) {
        this.inputStream = in;
        this.outputStream = out;

    }

    public void runProgram() {

    }
}
