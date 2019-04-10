package com.garyfimo.servicevsintentservice

import android.app.IntentService
import android.content.Intent
import java.util.logging.Logger

const val INTENT_SERVICE_NAME = "IntentServiceExample"

class IntentServiceExample : IntentService(INTENT_SERVICE_NAME) {

    val log = Logger.getLogger(IntentServiceExample::class.java.name)
    val counterExample: CounterExample by lazy { CounterExample() }

    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            val data = intent.getStringExtra("data")
            log.info("Message is : $data")
            if (data == "Start counting") {
                counterExample.count()
            } else {
                counterExample.discount()
            }
        }
    }
}