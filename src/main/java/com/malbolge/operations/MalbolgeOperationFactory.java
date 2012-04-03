package com.malbolge.operations;

import java.util.HashMap;
import java.util.Map;

import com.malbolge.MalbolgeRuntimeEnvironment;
import com.processor.Operation;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 15:44
 */
public class MalbolgeOperationFactory {
    private static final Map<Byte, MalbolgeOperation> operationsMap = new HashMap<Byte, MalbolgeOperation>()
    {
        {
            put(MalbolgeOperationCodes.CRAZY, new CrazyOperation());
            put(MalbolgeOperationCodes.END_OF_PROGRAM, new EndOfProgramOperation());
            put(MalbolgeOperationCodes.IN_A, new InputOperation());
            put(MalbolgeOperationCodes.JUMP_TO_VALUE_OF_D_PLUS_ONE, new JumpOperation());
            put(MalbolgeOperationCodes.MOVE_D_VALUE_TO_D, new MoveOperation());
            put(MalbolgeOperationCodes.NOP, new NoOperation());
            put(MalbolgeOperationCodes.OUT_A, new OutputOperation());
            put(MalbolgeOperationCodes.ROTD_D_VALUE_AND_MOVE_TO_A, new RotateAndMoveOperation());
        }
    };

    private static final Map<Class<? extends MalbolgeOperation>, Byte> reverseOperationsMap = new HashMap<Class<? extends MalbolgeOperation>, Byte>() {
        {
            put(CrazyOperation.class, MalbolgeOperationCodes.CRAZY);
            put(EndOfProgramOperation.class, MalbolgeOperationCodes.END_OF_PROGRAM);
            put(InputOperation.class, MalbolgeOperationCodes.IN_A);
            put(JumpOperation.class, MalbolgeOperationCodes.JUMP_TO_VALUE_OF_D_PLUS_ONE);
            put(MoveOperation.class, MalbolgeOperationCodes.MOVE_D_VALUE_TO_D);
            put(NoOperation.class, MalbolgeOperationCodes.NOP);
            put(OutputOperation.class, MalbolgeOperationCodes.OUT_A);
            put(RotateAndMoveOperation.class, MalbolgeOperationCodes.ROTD_D_VALUE_AND_MOVE_TO_A);
        }
    };

    public static final MalbolgeOperation createOperation(byte operationCode) {
        if (operationsMap.containsKey(operationCode)) {
            return operationsMap.get(operationCode);
        } else {
            return null;
        }
    }

    public static final Byte getOperatonCode(Operation<MalbolgeRuntimeEnvironment> operation) {
        return reverseOperationsMap.get(operation.getClass());
    }

    public static final boolean operationExists(byte code) {
        return operationsMap.containsKey(code);
    }
}
