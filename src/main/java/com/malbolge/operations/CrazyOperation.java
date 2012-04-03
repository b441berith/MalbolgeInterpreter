package com.malbolge.operations;

import com.malbolge.MalbolgeRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 17:41
 */
public class CrazyOperation implements MalbolgeOperation{
    public void execute(MalbolgeRuntimeEnvironment runtimeEnvironment) {
        int dValue = runtimeEnvironment.getDRegister().getValue();
        int a = runtimeEnvironment.getARegister().getMemoryPointer();
        int crazyValue = getCrazyValue(dValue, a);
        runtimeEnvironment.getARegister().setMemoryPointer(crazyValue);
        runtimeEnvironment.getDRegister().setValue(crazyValue);
    }

   public static int getCrazyValue(int input1, int input2) {
       return 0; //TODO impl
   }
}
