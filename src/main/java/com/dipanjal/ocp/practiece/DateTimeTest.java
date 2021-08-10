package com.dipanjal.ocp.practiece;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class DateTimeTest {

    public static boolean timeUtilTest() throws ParseException {

        Date fromDate = getTodayWithExactTime("12:14", "HH:mm");
        Date toDate = getTodayWithExactTime("17:50", "HH:mm");
        return isDateBetween(new Date(), fromDate, toDate);
    }

    private static Date getTodayWithExactTime(String time, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar fromCal = Calendar.getInstance();
        fromCal.setTime(sdf.parse(time));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, fromCal.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, fromCal.get(Calendar.MINUTE));
        return calendar.getTime();
    }

    private static boolean isDateBetween(Date dateToCompare, Date startDate, Date endDate){
        return !(dateToCompare.before(startDate) || dateToCompare.after(endDate));
    }

    private static boolean isAM(Date dateToCompare, SimpleDateFormat format) throws ParseException {
        Date start = format.parse("00:00");
        Date end = format.parse("11:59");
        return isDateBetween(dateToCompare, start, end);
    }

    private static boolean isPM(Date dateToCompare, SimpleDateFormat format) throws ParseException {
        Date start = format.parse("12:00");
        Date end = format.parse("23:59");
        return isDateBetween(dateToCompare, start, end);
    }

    public static void main(String[] args) {
        try {
            System.out.println(timeUtilTest());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
