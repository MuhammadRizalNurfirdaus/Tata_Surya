package com.pab.tata_surya

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pab.tata_surya.data.SolarSystemData
import com.pab.tata_surya.model.CelestialObject
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private var obj: CelestialObject? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolbar = findViewById<Toolbar>(R.id.toolbar_detail)
        val scroll = findViewById<View>(R.id.scroll_detail)
        val content = findViewById<View>(R.id.content_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val name = intent.getStringExtra("name") ?: return
        obj = SolarSystemData.findByName(name)
        obj?.let { o ->
            title = o.name
            findViewById<ImageView>(R.id.imageDetail).setImageResource(o.imageRes)
            findViewById<TextView>(R.id.textName).text = o.name
            findViewById<TextView>(R.id.textMass).text = getString(R.string.label_mass, o.mass)
            findViewById<TextView>(R.id.textDiameter).text = getString(R.string.label_diameter, o.diameterKm)
            findViewById<TextView>(R.id.textOrbit).text = getString(R.string.label_orbit, o.orbitPeriod)
            findViewById<TextView>(R.id.textDistance).text = getString(R.string.label_distance, o.distanceFromSunKm)
            findViewById<TextView>(R.id.textSatellites).text = getString(
                R.string.label_satellites,
                if (o.satellites.isEmpty()) getString(R.string.label_no_satellite) else o.satellites.joinToString(", ")
            )
            findViewById<TextView>(R.id.textDescription).text = o.description.repeat(5)
        }

        // Apply insets to avoid overlap with status/navigation bars
        val initialToolbarMarginTop = (toolbar.layoutParams as ViewGroup.MarginLayoutParams).topMargin
        val initialContentPaddingBottom = content.paddingBottom
        val initialContentPaddingLeft = content.paddingLeft
        val initialContentPaddingRight = content.paddingRight
        val initialContentPaddingTop = content.paddingTop
        ViewCompat.setOnApplyWindowInsetsListener(scroll) { _, insets ->
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> { finish(); true }
            R.id.action_share -> { shareObject(); true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareObject() {
        obj?.let { o ->
            val text = getString(R.string.share_template, o.name, o.diameterKm)
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, "Bagikan ${o.name}"))
        }
    }
}
