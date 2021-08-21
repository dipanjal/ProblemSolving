package com.dipanjal.bs23;

/**
 * @author dipanjal
 * @since 0.0.1
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class CarRental {

    private static boolean isOverlap(RentalTime slot1, RentalTime slot2) {
        return (slot1.getStart().getTime() <= slot2.getEnd().getTime())
                && (slot1.getEnd().getTime() >= slot2.getStart().getTime());
    }


    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {
        List<RentalTime> list = new ArrayList<>(rentalTimes);
        for(int i=0; i < list.size(); i++){
            RentalTime slot1 = list.get(i);
            for(int j=0; j < list.size(); j++){
                if(j == i) continue;
                RentalTime slot2 = list.get(j);
                if(isOverlap(slot1, slot2))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));

//        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:00")));
//        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:00"), sdf.parse("03/05/2020 21:00")));
//        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

class RentalTime {
    private Date start, end;

    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}