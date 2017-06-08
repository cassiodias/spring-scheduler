package com.cassio.cron.cron;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ParkedPivotManager {

    private Set<ParkedPivot> parkedPivots = new HashSet<>();

    void add(ParkedPivot parkedPivot) {
        this.parkedPivots.add(parkedPivot);
    }

    Integer waitingPivots() {
        return this.parkedPivots.size();
    }

    ParkedPivot pop() {
        return null; //parkedPivots
    }

    public void deleteOverdue() {
        this.parkedPivots.removeIf(parkedPivot -> parkedPivot.isOverDue());
    }

}