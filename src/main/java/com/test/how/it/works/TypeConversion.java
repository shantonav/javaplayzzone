package com.test.how.it.works;

public class TypeConversion {

    public Integer returnAPrimitiveInt(final int someIntValue){
        return Long.valueOf(someIntValue).intValue();
    }
}
