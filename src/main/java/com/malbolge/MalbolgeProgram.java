package com.malbolge;

import java.util.List;

import com.malbolge.operations.MalbolgeOperation;
import com.processor.AbstractProgram;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 15:44
 */
public class MalbolgeProgram extends AbstractProgram<MalbolgeOperation>{
    public MalbolgeProgram(List<MalbolgeOperation> operations) {
        super(operations);
    }
}
