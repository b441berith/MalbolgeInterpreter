package com.malbolge.operations;

import java.io.IOException;
import java.io.InputStream;

import com.malbolge.MalbolgeRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 17:35
 */
public class InputOperation implements MalbolgeOperation{
    public void execute(MalbolgeRuntimeEnvironment runtimeEnvironment) {
        final InputStream inputStream = runtimeEnvironment.getInputStream();
        if (inputStream != null) {
            try {
                int value = inputStream.read();
                runtimeEnvironment.getARegister().setMemoryPointer(value);
            } catch (IOException e) {
                throw new RuntimeException("Can't read from input stream");
            }
        } else {
            throw new RuntimeException("Input stream is null");
        }
    }
}
