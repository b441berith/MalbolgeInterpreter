package com.malbolge.vm;

import com.processor.vm.VMRegister;

/**
 * Malbolge VM uses integer-based registers
 *
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 16:01
 */
public class MalbolgeVMRegister implements VMRegister<Integer, Integer> {
    private Integer memoryPointer;
    private Integer value;

    public MalbolgeVMRegister(Integer memoryPointer, Integer value) {
        this.memoryPointer = memoryPointer;
        this.value = value;
    }

    public MalbolgeVMRegister() {
        this.memoryPointer = 0;
        this.value = 0;
    }

    public Integer getMemoryPointer() {
        return memoryPointer;
    }

    public void setMemoryPointer(Integer memoryPointer) {
        this.memoryPointer = memoryPointer;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
