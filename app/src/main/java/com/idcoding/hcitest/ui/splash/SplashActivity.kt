package com.idcoding.hcitest.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.idcoding.hcitest.R
import com.idcoding.hcitest.ui.MainActivity

/*
*  By Adya Bukhari
*  27 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        scheduleSplashScreen()
    }

    private fun scheduleSplashScreen() {
        val splashScreenDuration = getSplashScreenDuration()
        Handler().postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            },
            splashScreenDuration
        )
    }

    private fun getSplashScreenDuration() = 6000L
}
