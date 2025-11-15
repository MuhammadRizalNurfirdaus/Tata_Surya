package com.pab.tata_surya.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pab.tata_surya.R
import com.pab.tata_surya.model.CelestialObject

class CelestialObjectAdapter(
    private val items: List<CelestialObject>,
    private val onClick: (CelestialObject) -> Unit
) : RecyclerView.Adapter<CelestialObjectAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageObject)
        val name: TextView = view.findViewById(R.id.textName)
        val distance: TextView = view.findViewById(R.id.textDistance)
        val diameter: TextView = view.findViewById(R.id.textDiameter)
        val satCount: TextView = view.findViewById(R.id.textSatCount)
        val share: ImageView = view.findViewById(R.id.actionShare)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_celestial_object, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.imageRes)
        holder.name.text = item.name
        holder.distance.text = holder.itemView.context.getString(R.string.label_distance, item.distanceFromSunKm)
        holder.diameter.text = holder.itemView.context.getString(R.string.label_diameter, item.diameterKm)
        holder.satCount.text = item.satellites.size.toString()
        holder.itemView.setOnClickListener { onClick(item) }
        holder.share.setOnClickListener {
            val ctx = holder.itemView.context
            val text = ctx.getString(R.string.share_template, item.name, item.diameterKm)
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
            }
            ctx.startActivity(Intent.createChooser(sendIntent, ctx.getString(R.string.menu_share)))
        }
    }

    override fun getItemCount(): Int = items.size
}
