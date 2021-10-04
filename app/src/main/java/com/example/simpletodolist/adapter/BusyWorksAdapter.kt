package com.example.simpletodolist.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodolist.R
import com.example.simpletodolist.database.AppDataBase
import com.example.simpletodolist.database.MemoItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BusyWorksAdapter(private val context: Context, private var data: List<MemoItem>) :
    RecyclerView.Adapter<BusyWorksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position , data)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = itemView.findViewById(R.id.title_text)
        private val time: TextView = itemView.findViewById(R.id.time_text)
        private val checkbox: CheckBox = itemView.findViewById(R.id.end_checkbox)
        fun bind(position: Int , items:List<MemoItem>) {
            Log.d("태그", position.toString())

            title.text = items[position].title
            time.text = items[position].time
            checkbox.isChecked = items[position].isEnd

        }
    }
}