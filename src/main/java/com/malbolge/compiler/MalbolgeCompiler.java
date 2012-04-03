package com.malbolge.compiler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.malbolge.MalbolgeProgram;
import com.malbolge.operations.MalbolgeOperation;
import com.malbolge.operations.MalbolgeOperationFactory;
import com.processor.exceptions.CompilationException;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 15:57
 */
public class MalbolgeCompiler implements com.processor.Compiler<MalbolgeProgram> {
    private MalbolgeOperationFactory operationFactory;

    public MalbolgeCompiler(MalbolgeOperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public void compile(OutputStream outputStream, MalbolgeProgram program) throws CompilationException {
        if (outputStream == null || program == null || program.getOperations() == null || program.getOperations().isEmpty()) {
            return;
        }
        List<MalbolgeOperation> operations = program.getOperations();

        try {
            for (MalbolgeOperation operation : operations) {
                outputStream.write(operationFactory.getOperatonCode(operation));
            }
        } catch (IOException e) {
            throw new CompilationException("Error while writing to output stream");
        }
    }
}
