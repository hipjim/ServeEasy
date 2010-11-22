package com.serveeasy.model.program;

import com.serveeasy.model.users.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds the association between calendar days, weeks, months and Shifts
 * <p/>
 * TODO:  get this week program, get next week program, get x week program, get month program, get next month program
 * TODO: get x month program, move program from week -> week, move program from month -> month
 * TODO: set shit/day
 * TODO: copy shifts from day to day x, set for whole week, set for whole month
 * <p/>
 * User: elvis
 * Date: 14-Nov-2010
 * Time: 15:44:36
 */
public class WorkProgram {

    private Map<Calendar, WorkDay> program;
    //todo : in obiectul asta trebuie sa vina contextul sa-si seteze cum trebuie datele
    private Calendar now = Calendar.getInstance();

    //todo : probabil am nevoie si de obiectul de persistenta in b de date

    public WorkProgram() {
        this.program = new HashMap<Calendar, WorkDay>();
    }

    public void setWorkProgramForDay(Calendar date, WorkDay workDay) {
        this.program.put(date, workDay);
    }

    public void setWorkProgramForWeek(Calendar date, WorkDay workDay) {
        //if we are in the same week, then set the workDay for the remaining days in week
        int startWeekDay = 1;
        if (date.get(Calendar.WEEK_OF_YEAR) == now.get(Calendar.WEEK_OF_YEAR)) {
            startWeekDay = date.get(Calendar.DAY_OF_WEEK);
        }
        for (int i = startWeekDay; i <= 7; i++) {
            date.set(Calendar.DAY_OF_WEEK, i);
            this.setWorkProgramForDay(date, workDay);
        }
    }

    public void setWorkProgramForMonth(Calendar date, WorkDay workDay) {
        //if we are in the same month, then set the workDay for the remaining days in month
        int startDayInMonth = 1;
        if (date.get(Calendar.MONTH) == now.get(Calendar.MONTH)) {
            startDayInMonth = date.get(Calendar.DAY_OF_MONTH);
        }
        for (int i = startDayInMonth; i <= date.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            date.set(Calendar.DAY_OF_MONTH, i);
            this.setWorkProgramForDay(date, workDay);
        }
    }
//
//    public boolean setWorkProgramForYear(Calendar date, WorkDay workDay) {
//
//    }
//
//    public boolean copyWorkProgramFromDayToDay(Calendar dayFrom, Calendar dayTo) {
//
//    }
//
//    public boolean copyWorkProgramFromDayToWeek(Calendar dayFrom, Calendar weekTo) {
//
//    }
//
//    public boolean copyWorkProgramFromDayToMonth(Calendar dayFrom, Calendar monthTo) {
//
//    }
//
//    public boolean copyWorkProgramFromWeekToWeek(Calendar weekFrom, Calendar weekTo) {
//
//    }
//
//    public boolean copyWorkProgramFromWeekToMonth(Calendar weekFrom, Calendar monthTo) {
//
//    }
//
//    public boolean copyWorkProgramFromMonthToMonth(Calendar monthFrom, Calendar monthTo) {
//
//    }

}
