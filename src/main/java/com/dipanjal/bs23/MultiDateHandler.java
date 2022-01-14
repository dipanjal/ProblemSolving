package com.dipanjal.bs23;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MultiDateHandler {

    private static List<String> expectedDateFormats = List.of(
            "yyyy/MM/dd", "dd/MM/yyyy", "MM-dd-yyyy", "yyyyMMdd"
    );

    private static String convertDateStr(String sourceDateStr, String destDateFormat) {
        for (String pattern : expectedDateFormats) {
            try{
                LocalDate sourceDate = LocalDate.parse(sourceDateStr, DateTimeFormatter.ofPattern(pattern));
                return sourceDate.format(DateTimeFormatter.ofPattern(destDateFormat, Locale.ENGLISH));
            }catch (Exception e){
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> dateList = List.of(
               "2010/02/20",  "19/12/2016",
                "11-18-2012", "20130720"
        );

        List<String> resultList = new ArrayList<>();
        for (String str : dateList){
            String dateStr = convertDateStr(str, "yyyyMMdd");
            if(dateStr != null){
                resultList.add(dateStr);
                System.out.println("Input:"+str+" -- Output:"+dateStr);
            }
        }
    }
}
