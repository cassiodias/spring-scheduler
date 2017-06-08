package com.cassio.cron.cron

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CronApplicationSpec extends Specification {

    @Autowired
    ParkedPivotManager parkedPivotManager

    def "Name"() {
        expect:
        parkedPivotManager != null
    }

}
