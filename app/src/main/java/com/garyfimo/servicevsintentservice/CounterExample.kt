package com.garyfimo.servicevsintentservice

import java.util.logging.Logger

class CounterExample {

    val log = Logger.getLogger(CounterExample::class.java.name)

    fun count() {
        var i = 0
        while (i <= 10) {
            Thread.sleep(3000)
            i++
            log.info("Counting $i")
        }
        log.info("Counting finished")
    }

    fun discount() {
        var i = 10
        while (i >= 1) {
            Thread.sleep(3000)
            i--
            log.info("Discounting $i")
        }
        log.info("Discounting finished")
    }
}