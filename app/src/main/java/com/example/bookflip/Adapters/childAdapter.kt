package com.example.bookflip.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookflip.R
import com.example.bookflip.models.bookChild
import com.squareup.picasso.Picasso

class ChildAdapter( val context:Context, val bookChild:List<bookChild>):RecyclerView.Adapter<ChildAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.book_child,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.img.setImageResource(bookChild[position].imageUrl)
    }

    override fun getItemCount(): Int {
       return bookChild.size
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var img:ImageView
        init {
            img = itemView.findViewById(R.id.imageViewBook)
        }
    }
}