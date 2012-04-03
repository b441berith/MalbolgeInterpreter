package com.malbolge.operations;

import com.malbolge.MalbolgeRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 17:39
 */
public class MoveOperation implements MalbolgeOperation{
    public void execute(MalbolgeRuntimeEnvironment runtimeEnvironment) {
        int dValue = runtimeEnvironment.getDRegister().getValue();
        runtimeEnvironment.getDRegister().setMemoryPointer(dValue);
    }
}
