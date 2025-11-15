package com.pab.tata_surya

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pab.tata_surya.adapter.CelestialObjectAdapter
import com.pab.tata_surya.data.SolarSystemData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        val recycler = findViewById<RecyclerView>(R.id.recyclerViewObjects)
        setSupportActionBar(toolbar)

        // Properly apply system bar insets so the toolbar and list avoid overlapping the status/navigation bars
        val root = findViewById<View>(R.id.main)
        val initialToolbarMarginTop = (toolbar.layoutParams as ViewGroup.MarginLayoutParams).topMargin
        val initialRecyclerPaddingBottom = recycler.paddingBottom
        val initialRecyclerPaddingLeft = recycler.paddingLeft
        val initialRecyclerPaddingRight = recycler.paddingRight
        val initialRecyclerPaddingTop = recycler.paddingTop
        ViewCompat.setOnApplyWindowInsetsListener(root) { _, insets ->
            val sys = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            (toolbar.layoutParams as ViewGroup.MarginLayoutParams).apply {
                topMargin = initialToolbarMarginTop + sys.top
                toolbar.layoutParams = this
            }
            recycler.setPadding(
                initialRecyclerPaddingLeft,
                initialRecyclerPaddingTop,
                initialRecyclerPaddingRight,
                initialRecyclerPaddingBottom + sys.bottom
            )
            insets
        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL).apply {
                // optional: default divider
            }
        )
        recycler.adapter = CelestialObjectAdapter(SolarSystemData.objects) { obj ->
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("name", obj.name)
            startActivity(i)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> { startActivity(Intent(this, AboutActivity::class.java)); true }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
