package com.malbolge;

import java.io.InputStream;
import java.io.OutputStream;

import com.processor.ProgramRuntime;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 15:44
 */
public class MalbolgeProgramRuntime implements ProgramRuntime<MalbolgeRuntimeEnvironment, MalbolgeProgram> {
    public MalbolgeRuntimeEnvironment createRuntimeEnvironment(MalbolgeProgram program) {
        return new MalbolgeRuntimeEnvironment(System.in, System.out, program);
    }

    public MalbolgeRuntimeEnvironment createRuntimeEnvironment(InputStream in, OutputStream out, MalbolgeProgram program) {
        return new MalbolgeRuntimeEnvironment(in, out, program);
    }
}
