package com.pab.tata_surya

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val logo = findViewById<ImageView>(R.id.imageLogo)

        val rotate = ObjectAnimator.ofFloat(logo, "rotation", 0f, 360f).apply {
            duration = 1600
            interpolator = AccelerateDecelerateInterpolator()
        }
        val scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0.9f, 1f).apply {
            duration = 1600
            interpolator = DecelerateInterpolator()
        }
        val scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0.9f, 1f).apply {
            duration = 1600
            interpolator = DecelerateInterpolator()
        }

        AnimatorSet().apply {
            playTogether(rotate, scaleX, scaleY)
            start()
        }

        // Add a slight pause after the animation completes to feel polished
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1600 + 200L)
    }
}
