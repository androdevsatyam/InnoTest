package com.andro.innobuzz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.andro.innobuzz.R
import com.andro.innobuzz.db.UserData

class ListAdapter(val list: List<UserData>, val context: Context) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.title.text = list[position].title

        holder.title.setOnClickListener {
            val userData = list[holder.adapterPosition]
            val bundle = bundleOf(
                "title" to userData.title,
                "body" to userData.body
            )
            it.findNavController().navigate(R.id.show_detail, bundle)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
    }
}