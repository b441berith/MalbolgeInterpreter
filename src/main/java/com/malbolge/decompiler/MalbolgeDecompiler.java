package com.malbolge.decompiler;

import java.io.InputStream;

import com.malbolge.MalbolgeProgram;
import com.processor.Decompiler;
import com.processor.exceptions.DecompilationException;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 15:57
 */
public class MalbolgeDecompiler implements Decompiler<MalbolgeProgram>{
    public MalbolgeProgram decompile(InputStream inputStream) throws DecompilationException {
        return null;
    }
}
