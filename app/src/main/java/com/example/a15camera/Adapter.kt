package com.example.a15camera

import android.graphics.Bitmap
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var image: List<Bitmap>):
    RecyclerView.Adapter<Adapter.MyViewHolder>(){

    class MyViewHolder(iv: View) : RecyclerView.ViewHolder(iv){
        var image: ImageView? = iv.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(h: MyViewHolder, i: Int) {
        h.image?.setImageBitmap(image[i])
    }

    override fun getItemCount(): Int {
        return image.size
    }

}