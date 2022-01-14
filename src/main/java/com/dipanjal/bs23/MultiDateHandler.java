package com.dipanjal.bs23;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MultiDateHandler {

    private static final List<String> expectedDateFormats = List.of(
            "yyyy/MM/dd", "dd/MM/yyyy", "MM-dd-yyyy", "yyyyMMdd"
    );

    private static List<String> convertDateStr(List<String> dateList) {
        String destDateFormat = "yyyyMMdd";
        List<String> resultList = new ArrayList<>();
        for (String sourceDateStr : dateList){
            for (String pattern : expectedDateFormats) {
                try{
                    LocalDate sourceDate = LocalDate.parse(sourceDateStr, DateTimeFormatter.ofPattern(pattern));
                    String destDateStr = sourceDate.format(DateTimeFormatter.ofPattern(destDateFormat, Locale.ENGLISH));
                    resultList.add(destDateStr);
                }catch (Exception ignored){}
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<String> resultList = convertDateStr(List.of("2010/02/20",  "19/12/2016", "11-18-2012", "20130720"));
        resultList.forEach(System.out::println);
    }
}
