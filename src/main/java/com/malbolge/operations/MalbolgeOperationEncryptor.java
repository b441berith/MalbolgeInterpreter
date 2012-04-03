package com.malbolge.operations;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 18:10
 */
public class MalbolgeOperationEncryptor {
    public static final String encryptionString = "9m<.TVac`uY*MK'X~xDl}REokN:#?G\"i@5z]&gqtyfr$(we4{WP)H-Zn,[%\\3dL+Q;>U!pJS72FhOA1CB6v^=I_0/8|jsb";
    public static final int MIN_VALUE_TO_BE_ENCRYPTED = 0;
    public static final int MAX_VALUE_TO_BE_ENCRYPTED = 93;

    public static final int encrypt(int value) {
        if (value < MIN_VALUE_TO_BE_ENCRYPTED || value > MAX_VALUE_TO_BE_ENCRYPTED) {
            throw new IllegalArgumentException("Illegal value");
        }
        return encryptionString.charAt(value);
    }
}
