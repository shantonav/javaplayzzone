package test.com.solutions;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class DateTruncation {

    @Test

    public void testDateTruncationToOnlyMonthUsingSDF() throws ParseException {

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMyyyy");

        today = sdf.parse(sdf.format(today));

        System.out.println(today.toString());

        //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //System.out.println(sdf1.format(today));

        for (int i =0 ; i < 20 ; i++){
            System.out.println(UUID.randomUUID().toString());
        }

    }


}