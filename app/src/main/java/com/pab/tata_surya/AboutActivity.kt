package com.pab.tata_surya

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val toolbar = findViewById<Toolbar>(R.id.toolbar_about)
        val content = findViewById<View>(R.id.content_about)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "About"

        val initialToolbarMarginTop = (toolbar.layoutParams as ViewGroup.MarginLayoutParams).topMargin
        val initialContentPaddingBottom = content.paddingBottom
        val initialContentPaddingLeft = content.paddingLeft
        val initialContentPaddingRight = content.paddingRight
        val initialContentPaddingTop = content.paddingTop
        ViewCompat.setOnApplyWindowInsetsListener(content) { _, insets ->
            val sys = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            (toolbar.layoutParams as ViewGroup.MarginLayoutParams).apply {
                topMargin = initialToolbarMarginTop + sys.top
                toolbar.layoutParams = this
            }
            content.setPadding(
                initialContentPaddingLeft,
                initialContentPaddingTop,
                initialContentPaddingRight,
                initialContentPaddingBottom + sys.bottom
            )
            insets
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
