package test.com.solutions;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

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

        long[] timeStamps = {1576486194283l,1576486194217l,1576486194456l,1576486194115l,1576486194153l,1576486194225l};

        SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss.S");

        for ( long aTimeStamp : timeStamps){
            System.out.println(sdf1.format(new Date(aTimeStamp)));
        }
        LocalDate date =  LocalDate.now().withDayOfMonth(1).minusDays(1);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));

        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));

        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));

        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));

        LocalTime time = LocalTime.of(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));

        LocalDateTime ldt =  LocalDateTime.of(date, time);

        OffsetDateTime offsetDateTime = ldt.atOffset( ZoneOffset.UTC );

        System.out.print( offsetDateTime.toString() );

        String str = ",state:WA,country:US,postalCode:14530,city:Amsterdam" ;

        String[] addressTkoens = str.split(",");
        final Map<String, String> addressMap = new HashMap<>();

        Arrays.asList( addressTkoens ).stream().forEach( entry ->
        {
            if ( entry != null && !entry.equals("") ) {
                addressMap.put( entry.split(":")[0], entry.split(":")[1]);
            }
        });

        System.out.print( addressMap );



    }


}