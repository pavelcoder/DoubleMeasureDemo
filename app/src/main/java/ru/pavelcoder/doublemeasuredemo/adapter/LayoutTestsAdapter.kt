package ru.pavelcoder.doublemeasuredemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.pavelcoder.doublemeasuredemo.R
import ru.pavelcoder.doublemeasuredemo.activity.LayoutTest


class LayoutTestsAdapter(
    private val items: List<LayoutTest>,
    private val clickListener: (LayoutTest) -> Unit
) : RecyclerView.Adapter<TestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout_test, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = getId(holder.title.context, item.layoutId)
        holder.description.text = item.description
        holder.itemView.setOnClickListener {
            clickListener.invoke(item)
        }
    }

    private fun getId(context: Context, id: Int): String {
        return context.resources.getResourceName(id).split(":").last()
    }
}