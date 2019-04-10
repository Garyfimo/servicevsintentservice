package com.garyfimo.servicevsintentservice

import android.app.Service
import android.content.Intent
import android.os.AsyncTask
import android.os.IBinder
import java.util.logging.Logger

class OtherThreadServiceExample : Service() {
    val log = Logger.getLogger(OtherThreadServiceExample::class.java.name)

    override fun onCreate() {
        log.info("OtherThreadServiceExample onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log.info("OtherThreadServiceExample onStartCommand $startId")

        OtherThreadTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, startId)

        return Service.START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        log.info("OtherThreadServiceExample onBind")
        return null
    }

    private inner class OtherThreadTask : AsyncTask<Int, Int, String>() {

        override fun onPreExecute() {
            log.info("OtherThreadServiceExample preExecute")
        }

        override fun doInBackground(vararg params: Int?): String {

            val startId = params[0]

            CounterExample().count()

            return "OtherThreadServiceExample complete $startId"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            val counter = values.get(0)
            log.info("OtherThreadServiceExample Running $counter")
        }

        override fun onPostExecute(result: String) {
            log.info(result)
        }
    }
}