package com.malbolge.operations;

import com.malbolge.MalbolgeRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 17:31
 */
public class JumpOperation implements MalbolgeOperation{
    public void execute(MalbolgeRuntimeEnvironment runtimeEnvironment) {
        int dValue = runtimeEnvironment.getDRegister().getValue();
        runtimeEnvironment.getCRegister().setMemoryPointer(dValue+1);
    }
}
