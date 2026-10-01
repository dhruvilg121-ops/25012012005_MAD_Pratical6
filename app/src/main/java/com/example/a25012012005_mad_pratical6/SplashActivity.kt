package com.example.a25012012005_mad_pratical6

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var guniframeanimation: AnimationDrawable
    lateinit var imglogo: ImageView
    lateinit var gunianimation: Animation
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imglogo=findViewById(R.id.imglogo)
        imglogo.setBackgroundResource(R.drawable.uvpce_animation_list)
        guniframeanimation=imglogo.background as AnimationDrawable
        gunianimation= AnimationUtils.loadAnimation(this,R.anim.twin_animation)
        gunianimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            guniframeanimation.start()
            imglogo.startAnimation(gunianimation)

            // Navigate to MainActivity after exactly 5 seconds
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 5000L)
        }
        else{
            guniframeanimation.stop()
        }
    }

    override fun onAnimationEnd(p0: Animation?) {

    }

    override fun onAnimationRepeat(p0: Animation?) {

    }

    override fun onAnimationStart(p0: Animation?) {

    }
}