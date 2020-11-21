package com.example.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsletter.R
import com.example.newsletter.data.Category
import com.example.newsletter.data.Section

class AccueilAdapter(private val dataset: List<Section>, private val callback: CallBack) :
    RecyclerView.Adapter<AccueilAdapter.ViewHolder>() {
    inner class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Section) {
            val txtTitle = root.findViewById<TextView>(R.id.title)
            val img = root.findViewById<androidx.appcompat.widget.AppCompatImageView>(R.id.image)
            txtTitle.text = item.name
            Glide.with(root).load(item.image).into(img)
            root.setOnClickListener {
                callback.onClick(item.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_section, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size
}

