package com.garyfimo.servicevsintentservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.util.logging.Logger

class LargeServiceExample : Service() {

    val log = Logger.getLogger(LargeServiceExample::class.java.name)

    override fun onCreate() {
        log.info("LargeServiceExample onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log.info("LargeServiceExample onStartCommand $startId")
        var i = 0

        CounterExample().count()

        return Service.START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        log.info("LargeServiceExample onBind")
        return null
    }
}