package com.example.a25012012005_mad_pratical6

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val str = intent.getStringExtra("Service1")
        val serviceIntent = Intent(context, AlarmService::class.java)
        serviceIntent.putExtra("Service1", str)
        if (str == "Start") {
            context.startService(serviceIntent)
        } else {
            context.stopService(serviceIntent)
        }
    }
}
