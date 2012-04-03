package com.malbolge.operations;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 15:44
 */
public interface MalbolgeOperationCodes {
    public static final byte JUMP_TO_VALUE_OF_D_PLUS_ONE = 4;
    public static final byte OUT_A = 5;
    public static final byte IN_A = 23;
    public static final byte ROTD_D_VALUE_AND_MOVE_TO_A = 39;
    public static final byte MOVE_D_VALUE_TO_D = 40;
    public static final byte CRAZY = 62;
    public static final byte NOP = 68;
    public static final byte END_OF_PROGRAM = 81;
}
