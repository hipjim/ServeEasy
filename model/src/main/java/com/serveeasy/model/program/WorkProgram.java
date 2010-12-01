package com.serveeasy.model.program;

import org.joda.time.DateTime;

import java.util.ArrayList;
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


    public void setWorkProgramForYear(DateTime date, WorkDay workDay) {
        DateTime firstDayOfYear = date.dayOfYear().setCopy(date.dayOfYear().getMinimumValue());
        DateTime lastDayOfYear = date.dayOfYear().setCopy(date.dayOfYear().getMaximumValue());
        for (int i = firstDayOfYear.getDayOfYear(); i <= lastDayOfYear.getDayOfYear(); i++) {
            setWorkProgramForDay(firstDayOfYear, workDay);
            firstDayOfYear = firstDayOfYear.plusDays(1);
        }
    }

    public void copyWorkProgramFromDayToDay(DateTime dayFrom, DateTime dayTo) {
        setWorkProgramForDay(dayTo, program.get(dayFrom));
    }

    public void copyWorkProgramFromDayToWeek(DateTime dayFrom, DateTime dayTo) {
        setWorkProgramForWeek(dayTo, program.get(dayFrom));
    }

    public void copyWorkProgramFromDayToMonth(DateTime dayFrom, DateTime dayTo) {
        setWorkProgramForMonth(dayTo, program.get(dayFrom));
    }

    public void copyWorkProgramFromWeekToWeek(DateTime dayFrom, DateTime dayTo) {
        DateTime firstDayOfWeekFrom = dayFrom.dayOfWeek().setCopy(dayFrom.dayOfWeek().getMinimumValue());
        DateTime lastDayOfWeekFrom = dayFrom.dayOfWeek().setCopy(dayFrom.dayOfWeek().getMaximumValue());
        DateTime firstDayOfWeekTo = dayTo.dayOfWeek().setCopy(dayTo.dayOfWeek().getMinimumValue());
        for (int i = firstDayOfWeekFrom.getDayOfMonth(); i <= lastDayOfWeekFrom.getDayOfMonth(); i++) {
            WorkDay wd = program.get(firstDayOfWeekFrom);
            if (wd != null) {
                setWorkProgramForDay(firstDayOfWeekTo, wd);
            }
            firstDayOfWeekFrom = firstDayOfWeekFrom.plusDays(1);
            firstDayOfWeekTo = firstDayOfWeekTo.plusDays(1);
        }
    }
//
//    public void copyWorkProgramFromWeekToMonth(DateTime weekFrom, DateTime monthTo) {
//
//    }
//
//    public void copyWorkProgramFromMonthToMonth(DateTime monthFrom, DateTime monthTo) {
//
//    }

    public Map<DateTime, WorkDay> getProgram() {
        return program;
    }

    public WorkDay getWorkDay(DateTime day) {
        return program.get(day);
    }

    //todo : testare metoda asta
    public List<WorkDay> getWorkWeek(DateTime day) {
        List<WorkDay> weekProgram = new ArrayList<WorkDay>();
        for (DateTime dayInProgram : program.keySet()) {
            if (dayInProgram.getWeekOfWeekyear() == day.getWeekOfWeekyear()) {
                weekProgram.add(program.get(dayInProgram));
            }
        }
        return weekProgram;
    }

    
    //@Override
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
