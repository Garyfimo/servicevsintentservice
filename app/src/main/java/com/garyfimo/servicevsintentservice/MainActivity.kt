package com.garyfimo.servicevsintentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIntentServiceOne?.setOnClickListener { onClickIntentServiceOne() }
        btnIntentServiceTwo?.setOnClickListener { onClickIntentServiceTwo() }
        btnLargeService?.setOnClickListener { onClickLargeService() }
        btnOtherThreadService?.setOnClickListener { onClickOtherThreadService() }
    }

    private fun onClickOtherThreadService() {
        val intent = Intent(this, OtherThreadServiceExample::class.java)
        startService(intent)
    }

    private fun onClickLargeService() {
        val intent = Intent(this, LargeServiceExample::class.java)
        startService(intent)
    }

    private fun onClickIntentServiceTwo() {
        val intent = Intent(this, IntentServiceExample::class.java)
            .apply {
                putExtra("data", "Start discounting")
            }
        startService(intent)
    }

    private fun onClickIntentServiceOne() {
        val intent = Intent(this, IntentServiceExample::class.java)
            .apply {
                putExtra("data", "Start counting")
            }
        startService(intent)
    }
}
