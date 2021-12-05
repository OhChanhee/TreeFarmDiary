package com.example.simpletodolist.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodolist.R
import com.example.simpletodolist.database.TreeWithDiaryData
import com.example.simpletodolist.util.DiaryItemDiffCallback

class WriteDiaryRecyclerviewAdapter : RecyclerView.Adapter<WriteDiaryRecyclerviewAdapter.ViewHolder>()
{
    var data = mutableListOf<Bitmap>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WriteDiaryRecyclerviewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: WriteDiaryRecyclerviewAdapter.ViewHolder, position: Int) {
        holder.bind(position,data)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val image : ImageView = itemView.findViewById(R.id.image_item_iv)
        private val frame : ImageView = itemView.findViewById(R.id.image_item_frame)
        fun bind(position: Int,items:List<Bitmap>){
            //val imageBytes = Base64.decode(items[position], Base64.DEFAULT)
            //val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            image.setImageBitmap(items[position])

            frame.setOnClickListener{
                data.removeAt(position)
                notifyDataSetChanged()
            }
        }
    }

}