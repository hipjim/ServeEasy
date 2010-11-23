package com.serveeasy.model.program;

import com.serveeasy.model.users.User;

import java.util.*;

/**
 * Holds the association between calendar days, weeks, months and Shifts
 * <p/>
 * TODO:  get this week program, get next week program, get x week program, get month program, get next month program
 * TODO: get x month program, move program from week -> week, move program from month -> month
 * TODO: set shit/day
 * TODO: copy shifts from day to day x, set for whole week, set for whole month
 *
 * todo : asta trebuie testat foarte bine, pentru toate metodele existente mai ales pentru treceri de la o luna la alta
 * todo: de la un an la altul, pentru luni care se termina l;a jumatatea saptamanii s.a.m.d
 *
 * <p/>
 * User: elvis
 * Date: 14-Nov-2010
 * Time: 15:44:36
 */
public class WorkProgram {

    private Map<Calendar, WorkDay> program;
    //todo : in obiectul asta trebuie sa vina contextul sa-si seteze cum trebuie datele
    private Calendar now = new GregorianCalendar();

    //todo : probabil am nevoie si de obiectul de persistenta in b de date

    public WorkProgram() {
        this.program = new HashMap<Calendar, WorkDay>();
    }

    public void setWorkProgramForDay(Calendar date, WorkDay workDay) {
        this.program.put(date, workDay);
    }

    public void setWorkProgramForWeek(Calendar date, WorkDay workDay) {
        for (int i = date.get(Calendar.DAY_OF_MONTH);
             i < date.get(Calendar.DAY_OF_MONTH) + 7;
             i++) {
            Calendar c = new GregorianCalendar();
            c.set(GregorianCalendar.DAY_OF_MONTH, i);
            this.setWorkProgramForDay(c, workDay);
        }
    }

    public void setWorkProgramForMonth(Calendar date, WorkDay workDay) {
        for (int i = date.get(Calendar.DAY_OF_MONTH); i <= date.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            Calendar c = new GregorianCalendar();
            c.set(GregorianCalendar.DAY_OF_MONTH, i);

            this.setWorkProgramForDay(c, workDay);
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

    public Map<Calendar, WorkDay> getProgram() {
        return this.program;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Calendar day : this.program.keySet()) {
            int month = day.get(Calendar.MONTH) + 1;
            sb.append("Date: " + day.get(Calendar.YEAR) + "-" + month + "-" + day.get(Calendar.DAY_OF_MONTH));
            sb.append("\nWorkDay:" + this.program.get(day));
            sb.append("\n\n");
        }
        return sb.toString();
    }
}
