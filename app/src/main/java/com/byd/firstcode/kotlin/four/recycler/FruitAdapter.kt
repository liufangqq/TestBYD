package com.byd.firstcode.kotlin.four.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.byd.firstcode.kotlin.R
import com.byd.firstcode.kotlin.four.Fruit
import org.jetbrains.anko.toast

class FruitAdapter(val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            view.context.toast("you click ${fruit.name}")
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            view.context.toast("you click ${fruit.name}")
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitName = view.findViewById<TextView>(R.id.fruitName)
        val fruitImage = view.findViewById<ImageView>(R.id.fruitImage)
    }

    override fun getItemCount(): Int = fruitList.size

}