package com.example.a25012012005_mad_pratical6

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class AlarmService : Service() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            val action = intent.getStringExtra("Service1")
            if (action == "Start") {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI)
                    mediaPlayer?.isLooping = true
                    mediaPlayer?.start()
                }
            } else if (action == "Stop") {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }
}
