package test.com.solutions;

import com.test.how.it.works.TypeConversion;
import org.junit.Assert;
import org.junit.Test;

public class TestJavaTypeConversion {

    @Test
    public void  testMethodReturnConversion(){
        final int somevalue = 3000;
        Integer intObject = new TypeConversion().returnAPrimitiveInt(somevalue);

        Assert.assertEquals(somevalue, intObject.intValue());
    }
}
