package com.example.bookflip.Adapters

import android.content.Context
import android.icu.text.CaseMap.Title
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookflip.R
import com.example.bookflip.models.bookChild
import com.example.bookflip.models.BookParent

class ParentAdapter(val context: Context,val collection: List<BookParent>):RecyclerView.Adapter<ParentAdapter.MyViewHolder>() {

    inner  class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var bookTitle:TextView
        lateinit var bookRecyclerView: RecyclerView
        init {
                bookTitle = itemView.findViewById(R.id.title)
                bookRecyclerView=itemView.findViewById(R.id.recyclerViewBooks)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_parent,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bookTitle.text = collection[position].title
        setItem(holder.bookRecyclerView,collection[position].collection)
    }

    override fun getItemCount(): Int {
       return collection.size
    }

    private  fun setItem(recyclerView: RecyclerView,bookItem:List<bookChild>){
        val childAdapter = ChildAdapter(context ,bookItem)
        recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        recyclerView.adapter = childAdapter
    }
}