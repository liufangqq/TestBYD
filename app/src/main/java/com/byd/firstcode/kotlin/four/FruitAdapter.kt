package com.byd.firstcode.kotlin.four

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.fruit_item.view.*

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/17
 * desc :
 * version: 1.0
 * </pre>
 */
class FruitAdapter(val activity: Activity, val resourceId:Int,val data:List<Fruit>):ArrayAdapter<Fruit>(activity,
resourceId,data) {
    inner class ViewHolder(val fruitImage:ImageView,val fruitName:TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view:View
        val viewHolder:ViewHolder
        if(convertView==null){
            view=  LayoutInflater.from(context).inflate(resourceId,parent,false)
            val fruitImage:ImageView = view.findViewById(R.id.fruitImage)
            val fruitName:TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage,fruitName)
            view.tag=viewHolder
        }else{
            view = convertView
viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position)
        if(fruit!=null){
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.setText(fruit.name)
        }
        return view
    }


}