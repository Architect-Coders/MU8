package com.architect.coders.mu8.events

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.architect.coders.mu8.R
import com.architect.coders.mu8.events.EventsAdapter.ViewHolder
import com.architect.coders.mu8.utils.inflate
import com.architect.coders.mu8.utils.loadUrl
import com.architect.codes.mu8.events.Event
import kotlin.properties.Delegates

class EventsAdapter : RecyclerView.Adapter<ViewHolder>() {

    var events: List<Event> by Delegates.observable(
        emptyList(),
        { _, _, _ -> notifyDataSetChanged() }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.event_item))
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(events[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var image: ImageView = itemView.findViewById(R.id.image)
        private var title: TextView = itemView.findViewById(R.id.title)

        fun bind(item: Event) {

            image.loadUrl(item.thumbnail)
            title.text = item.title
        }
    }
}
