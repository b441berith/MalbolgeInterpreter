package com.malbolge.operations;

import java.io.IOException;
import java.io.OutputStream;

import com.malbolge.MalbolgeRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 17:35
 */
public class OutputOperation implements MalbolgeOperation{
    public void execute(MalbolgeRuntimeEnvironment runtimeEnvironment) {
        final OutputStream outputStream = runtimeEnvironment.getOutputStream();
        if (outputStream != null) {
            try {
                int a = runtimeEnvironment.getARegister().getMemoryPointer();
                outputStream.write(a);
            } catch (IOException e) {
                throw new RuntimeException("Can't write to output stream");
            }
        } else {
            throw new RuntimeException("Output stream is null");
        }
    }
}
