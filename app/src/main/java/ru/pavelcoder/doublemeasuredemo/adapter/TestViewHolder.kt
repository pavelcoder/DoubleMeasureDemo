package ru.pavelcoder.doublemeasuredemo.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.pavelcoder.doublemeasuredemo.R

class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById<TextView>(R.id.rltLayout)
    val description = itemView.findViewById<TextView>(R.id.rltDescription)
}