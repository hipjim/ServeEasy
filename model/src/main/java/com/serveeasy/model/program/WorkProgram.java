package com.serveeasy.model.program;

import org.joda.time.DateTime;

import java.util.*;


/**
 * Holds the association between calendar days and working days
 *
 * User: elvis
 * Date: 14-Nov-2010
 * Time: 15:44:36
 */
public class WorkProgram {

    private Map<DateTime, WorkDay> program;
    
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

    public Map<DateTime, WorkDay> getProgram() {
        return program;
    }

    public WorkDay getWorkDay(DateTime day) {
        return program.get(day);
    }

    public List<WorkDay> getWorkWeek(DateTime day) {
        List<WorkDay> weekProgram = new ArrayList<WorkDay>();
        for (DateTime dayInProgram : program.keySet()) {
            if (dayInProgram.getWeekOfWeekyear() == day.getWeekOfWeekyear() &&
                    dayInProgram.getYear() == day.getYear()) {
                weekProgram.add(program.get(dayInProgram));
            }
        }
        return weekProgram;
    }

    public List<WorkDay> getWorkMonth(DateTime day) {
        List<WorkDay> monthProgram = new ArrayList<WorkDay>();
        for (DateTime dayInProgram : program.keySet()) {
            if (dayInProgram.getMonthOfYear() == day.getMonthOfYear() &&
                    day.getYear() == dayInProgram.getYear()) {
                monthProgram.add(program.get(dayInProgram));
            }
        }
        return monthProgram;
    }

    public void removeWorkDay(DateTime day) {
        program.remove(day);
    }

    public void removeWorkWeek(DateTime day) {
        Iterator<Map.Entry<DateTime, WorkDay>> it = (Iterator< Map.Entry <DateTime, WorkDay>>)program.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<DateTime, WorkDay> pairs = it.next();
            DateTime dayInProgram = pairs.getKey();
            if (dayInProgram.getWeekOfWeekyear() == day.getWeekOfWeekyear() &&
                    dayInProgram.getYear() == day.getYear()) {
                it.remove();
            }
        }
    }

    public void removeWorkMonth(DateTime day) {
        Iterator<Map.Entry<DateTime, WorkDay>> it = (Iterator< Map.Entry <DateTime, WorkDay>>)program.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<DateTime, WorkDay> pairs = it.next();
            DateTime dayInProgram = pairs.getKey();
            if (dayInProgram.getMonthOfYear() == day.getMonthOfYear() &&
                    dayInProgram.getYear() == day.getYear()) {
                it.remove();
            }
        }
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
