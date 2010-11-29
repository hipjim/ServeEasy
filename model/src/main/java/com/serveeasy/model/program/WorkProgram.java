package com.serveeasy.model.program;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.Period;

import java.util.HashMap;
import java.util.Map;


/**
 * Holds the association between calendar days, weeks, months and Shifts
 * <p/>
 * TODO:  get this week program, get next week program, get x week program, get month program, get next month program
 * TODO: get x month program, move program from week -> week, move program from month -> month
 * TODO: set shit/day
 * TODO: copy shifts from day to day x, set for whole week, set for whole month
 * TODO: set program for this kind of day for whole month, for 3 months, whole year - seteaza programul de joi pentru
 * TODO: toate zilele de joi din luna/an sau o anumita perioada  
 * <p/>
 * todo : asta trebuie testat foarte bine, pentru toate metodele existente mai ales pentru treceri de la o luna la alta
 * todo: de la un an la altul, pentru luni care se termina la jumatatea saptamanii s.a.m.d
 * <p/>
 * <p/>
 * <p/>
 * User: elvis
 * Date: 14-Nov-2010
 * Time: 15:44:36
 */
public class WorkProgram {

    private Map<DateTime, WorkDay> program;
    //todo : in obiectul asta trebuie sa vina contextul sa-si seteze cum trebuie datele\
    //todo: ar trebui o functionalitate de overwrite pe true sau false

    public WorkProgram() {
        program = new HashMap<DateTime, WorkDay>();
    }

    public WorkProgram(Map<DateTime, WorkDay> program) {
        this.program = program;
    }

    public void setWorkProgramForDay(DateTime date, WorkDay workDay) {
        program.put(date, workDay);
    }

    public void setWorkProgramForWeek(DateTime date, WorkDay workDay) {
        DateTime firstDayOfWeek = date.dayOfWeek().setCopy(date.dayOfWeek().getMinimumValue());
        DateTime lastDayOfWeek = date.dayOfWeek().setCopy(date.dayOfWeek().getMaximumValue());
        for (int i = firstDayOfWeek.getDayOfMonth(); i <= lastDayOfWeek.getDayOfMonth(); i++) {
            setWorkProgramForDay(firstDayOfWeek, workDay);
            firstDayOfWeek = firstDayOfWeek.plusDays(1);
        }
    }

    public void setWorkProgramForMonth(DateTime date, WorkDay workDay) {
        DateTime firstDayOfMonth = date.dayOfMonth().setCopy(date.dayOfMonth().getMinimumValue());
        DateTime lastDayOfMonth = date.dayOfMonth().setCopy(date.dayOfMonth().getMaximumValue());
        for (int i = firstDayOfMonth.getDayOfMonth(); i <= lastDayOfMonth.getDayOfMonth(); i++) {
            setWorkProgramForDay(firstDayOfMonth, workDay);
            firstDayOfMonth = firstDayOfMonth.plusDays(1);
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

    public Map<DateTime, WorkDay> getProgram() {
        return program;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DateTime dt : program.keySet()) {
            int month = dt.getMonthOfYear();
            sb.append("Date: " + dt.getYear() + "-" + month + "-" + dt.getDayOfMonth());
            sb.append("\nWorkDay:" + program.get(dt));
            sb.append("\n\n");
        }
        return sb.toString();
    }
}
