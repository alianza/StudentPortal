package com.example.studentportal

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(private val portals: List<Portal>) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    private fun onItemClick(portal: Portal, view: View) {
//        val uris = Uri.parse(portal.url)
//        val intents = Intent(Intent.ACTION_VIEW, uris)
//        val b = Bundle()
//        b.putBoolean("new_window", true)
//        intents.putExtras(b)
        //not working
//        context.startActivity(intents)

        Toast.makeText(view.context,"Clicked on: " + portal.url, Toast.LENGTH_SHORT).show()
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return portals.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        fun bind(portal: Portal) {
            itemView.clItemPortal.setBackgroundColor(Color.WHITE)
            itemView.tvTitle.text = portal.title
            itemView.tvUrl.text = portal.url
        }
        init {
            itemView.setOnClickListener { onItemClick(portals[adapterPosition], itemView) }
        }
    }
}