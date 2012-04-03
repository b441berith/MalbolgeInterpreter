package com.malbolge.operations;

import com.malbolge.MalbolgeRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 17:37
 */
public class RotateAndMoveOperation implements MalbolgeOperation{
    public void execute(MalbolgeRuntimeEnvironment runtimeEnvironment) {
        int dValue = runtimeEnvironment.getDRegister().getValue();
        //rotate the value of d by one ternary digit. 0002111112 becomes 2000211111
        int rotated = dValue; //TODO impl
        runtimeEnvironment.getDRegister().setValue(rotated);
        runtimeEnvironment.getARegister().setMemoryPointer(rotated);
    }
}
