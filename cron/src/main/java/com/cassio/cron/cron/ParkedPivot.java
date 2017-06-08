package com.cassio.cron.cron;

import java.time.LocalDateTime;

public class ParkedPivot {

    private Integer minutes;
    private Pivot pivot;
    private LocalDateTime timeStamp = LocalDateTime.now();

    public ParkedPivot(Integer minutes, Pivot pivot) {
        this.minutes = minutes;
        this.pivot = pivot;
    }

    public Pivot getPivot() {
        return pivot;
    }

    public boolean isOverDue() {
        return LocalDateTime.now().isAfter(timeStamp.plusMinutes(minutes));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkedPivot that = (ParkedPivot) o;

        if (minutes != null ? !minutes.equals(that.minutes) : that.minutes != null) return false;
        if (pivot != null ? !pivot.equals(that.pivot) : that.pivot != null) return false;
        return timeStamp != null ? timeStamp.equals(that.timeStamp) : that.timeStamp == null;
    }

    @Override
    public int hashCode() {
        int result = minutes != null ? minutes.hashCode() : 0;
        result = 31 * result + (pivot != null ? pivot.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParkedPivot{" +
                "minutes=" + minutes +
                ", pivot=" + pivot +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
