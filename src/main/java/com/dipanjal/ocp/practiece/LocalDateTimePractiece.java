package com.dipanjal.ocp.practiece;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * @author dipanjal
 * @since 4/17/2021
 */

public class LocalDateTimePractiece {

    public static void testLocalFormatting(Locale locale){
        BigDecimal price = BigDecimal.valueOf(1199.99);
        Double tax = 0.2;
        int quantity = 1000000;

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        System.out.println("Price: "+currencyFormat.format(price));
        System.out.println("Tax(%): "+percentFormat.format(tax));
        System.out.println("Quantity: "+numberFormat.format(quantity));

    }

    private static String formatDateTime(final LocalDateTime dateTime){
        String dateTimeFormat = "EEEE dd-MMM-yyyy hh:mm:ss a";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        return dateTime.format(formatter);
    }

    private static void printDuration(LocalDateTime from, LocalDateTime to){
        Duration duration = Duration.between(from, to);
        System.out.println("START: "+formatDateTime(from));
        System.out.println("END: "+formatDateTime(to));
        System.out.println(String.format("Duration %sh %sm %ss: ", duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart()));
    }

    private static void calculateDuration(long minutes){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusMinutes(minutes);
        printDuration(now, future);
    }

    private static void calculateDuration(long... minutes){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = LocalDateTime.now();
        for(long min : minutes){
            future = future.plusMinutes(min);
        }
        printDuration(now, future);
    }

    public static void main(String... args) {
//        calculateDuration(153);
//        calculateDuration(21, 16, 18, 7, 16, 8);
//        calculateDuration(24, 21, 16, 12, 16, 17, 17, 18, 9);
//        calculateDuration(24,22,15, 27, 22, 5);
        calculateDuration(24, 16);

        /*ZoneId dhakaZoneId = ZoneId.getAvailableZoneIds()
                .stream()
                .filter(id -> id.contains("Dhaka"))
                .findFirst()
                .map(ZoneId::of)
                .orElse(ZoneId.of("GMT+6"));

        ZoneId brusselsZoneId = ZoneId.getAvailableZoneIds()
                .stream()
                .filter(id -> id.contains("Brussels"))
                .findFirst()
                .map(ZoneId::of)
                .orElse(ZoneId.of("GMT+2"));
        ZonedDateTime dhakaTime = ZonedDateTime.of(LocalDateTime.now(), dhakaZoneId);
        ZonedDateTime brusselsTime = dhakaTime.withZoneSameInstant(brusselsZoneId);
        Duration timeGap = Duration.between(brusselsTime.toLocalDateTime(), dhakaTime.toLocalDateTime());

        String dateTimeFormat = "EEEE dd-MMM-yyyy hh:mm:ss a";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);

        System.out.println(dhakaTime.format(formatter.withZone(dhakaZoneId)));
        System.out.println(brusselsTime.format(formatter.withZone(brusselsZoneId)));
        System.out.println("Difference: "+ timeGap.toHours() + " Hours");
        System.out.println("GMT Offset of Dhaka: GMT"+dhakaTime.getOffset());
        System.out.println("GMT Offset of Brussels: GMT"+brusselsTime.getOffset());

        testLocalFormatting(new Locale("en", "US"));
        testLocalFormatting(Locale.forLanguageTag("Bn"));*/

    }
}
