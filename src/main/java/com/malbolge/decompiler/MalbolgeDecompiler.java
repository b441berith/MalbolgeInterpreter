package com.malbolge.decompiler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.malbolge.MalbolgeProgram;
import com.malbolge.operations.MalbolgeOperation;
import com.malbolge.operations.MalbolgeOperationFactory;
import com.processor.Decompiler;
import com.processor.exceptions.DecompilationException;

/**
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 15:57
 */
public class MalbolgeDecompiler implements Decompiler<MalbolgeProgram>{
    public MalbolgeProgram decompile(InputStream inputStream) throws DecompilationException {
        if (inputStream == null) {
            throw new DecompilationException("Can't decompile from null input stream");
        }
        //assuming program text is enough to fit in memory
        final char[] buffer = new char[0x10000];
        StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream);
        int read;
        try {
            do {
                read = in.read(buffer, 0, buffer.length);
                if (read > 0) {
                    out.append(buffer, 0, read);
                }

            } while (read >= 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = out.toString();
        List<MalbolgeOperation> operations = new ArrayList<MalbolgeOperation>();
        for (char ch : result.toCharArray()) {
            MalbolgeOperation operation = MalbolgeOperationFactory.createOperation((byte)ch);
            if (operation != null) {
                operations.add(operation);
            }
        }
        return new MalbolgeProgram(operations);
    }
}
