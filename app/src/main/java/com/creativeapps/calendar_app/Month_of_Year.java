package com.creativeapps.calendar_app;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by Sifat on 1/11/2018.
 */
public class Month_of_Year {


    //Calendar.Sunday=1;
    //Calendar.Saturday=7;
    //Calendar.January=0;
    //Calendar.Decembar=11;

    //month_index january=0;December=11;
    //day_index sat=0;fri=6


    int number_of_days,first_day,month_index,year;

    public Month_of_Year(int month_index,int year) {

        this.month_index=month_index;
        this.year=year;
    }

    public int getNumber_of_days() {
        switch (month_index){
            case 0: return  31;
            case 1: return  28;
            case 2: return  31;
            case 3: return  30;
            case 4: return  31;
            case 5: return  30;
            case 6: return  31;
            case 7: return  31;
            case 8: return  30;
            case 9: return 31;
            case 10: return 30;
            case 11: return 31;
            default: return 0;


        }
    }

    public int getFirst_day() {
       return get_day_from_date(month_index,1);
    }

    public int get_day_from_date(int month,int date){

        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DATE, date);


        return  getDayIndex(c.get(Calendar.DAY_OF_WEEK));


    }

    private int getDayIndex(int i) {

        switch (i) {
            case Calendar.SATURDAY:
                return 0;
            case Calendar.SUNDAY:
                return 1;
            case Calendar.MONDAY:
                return 2;
            case Calendar.TUESDAY:
                return 3;
            case Calendar.WEDNESDAY:
                return 4;
            case Calendar.THURSDAY:
                return 5;
            case Calendar.FRIDAY:
                return 6;
            default: return 100;

        }
    }

    public String get_month_name(){


        switch (month_index){

            case 0: return  "January";
            case 1: return  "February";
            case 2: return  "March";
            case 3: return  "April";
            case 4: return  "May";
            case 5: return  "June";
            case 6: return  "July";
            case 7: return  "August";
            case 8: return  "September";
            case 9: return "October";
            case 10: return "November";
            case 11: return "December";
            default: return "";



        }

    }


}
