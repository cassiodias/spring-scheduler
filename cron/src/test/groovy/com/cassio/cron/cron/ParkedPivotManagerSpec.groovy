package com.cassio.cron.cron

import spock.lang.Specification

import java.util.function.Predicate

class ParkedPivotManagerSpec extends Specification {

    def "must add one pivot at once"() {
        given:
        ParkedPivotManager parkedPivotManager = new ParkedPivotManager()

        when:
        ParkedPivot parkedPivot = new ParkedPivot(1, new Pivot(1))
        parkedPivotManager.add(parkedPivot)
        parkedPivotManager.add(parkedPivot)
        parkedPivotManager.add(parkedPivot)

        then:
        parkedPivotManager.waitingPivots() == 1
    }

    def "must remove execute the clean up"() {
        given:
        Set<ParkedPivot> parkedPivots = Spy(Set)
        ParkedPivotManager parkedPivotManager = new ParkedPivotManager(parkedPivots: parkedPivots)

        when:
        parkedPivotManager.deleteOverdue()

        then:
        1 * parkedPivots.removeIf(_ as Predicate) >> true
    }

    def "must pop the next Pivot in the queue"() {
        given:
        ParkedPivotManager parkedPivotManager = new ParkedPivotManager()
        parkedPivotManager.add(new ParkedPivot(5, new Pivot(1)))
        parkedPivotManager.add(new ParkedPivot(5, new Pivot(2)))
        parkedPivotManager.add(new ParkedPivot(5, new Pivot(3)))

        when:
        parkedPivotManager.pop()

        then:
        parkedPivotManager.waitingPivots() == 2

        when:
        parkedPivotManager.pop()

        then:
        parkedPivotManager.waitingPivots() == 1

        when:
        parkedPivotManager.pop()

        then:
        parkedPivotManager.waitingPivots() == 0
    }
}
