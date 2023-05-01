package com.example.bookflip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookflip.Adapters.ChildAdapter
import com.example.bookflip.Adapters.ParentAdapter
import com.example.bookflip.models.BookParent
import com.example.bookflip.models.bookChild

class MainActivity : AppCompatActivity() {

    lateinit var  mainRecyclerView: RecyclerView
    lateinit var mainAdapter: ParentAdapter
    lateinit var clickAdapter: ChildAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val content1 = ArrayList<bookChild>()
        content1.add(bookChild(1,R.drawable.winfriends))
        content1.add(bookChild(1,R.drawable.pyschologymoney))
        content1.add(bookChild(1,R.drawable.richdad))
        content1.add(bookChild(1,R.drawable.atomichabits))

        val content2 = ArrayList<bookChild>()
        content2.add(bookChild(2,R.drawable.richdad))
        content2.add(bookChild(2,R.drawable.pyschologymoney))
        content2.add(bookChild(2,R.drawable.winfriends))
        content2.add(bookChild(2,R.drawable.atomichabits))

        val content3 = ArrayList<bookChild>()
        content3.add(bookChild(3,R.drawable.atomichabits))
        content3.add(bookChild(3,R.drawable.richdad))
        content3.add(bookChild(3,R.drawable.pyschologymoney))
        content3.add(bookChild(3,R.drawable.winfriends))

        val content4 = ArrayList<bookChild>()
        content4.add(bookChild(4,R.drawable.winfriends))
        content4.add(bookChild(4,R.drawable.pyschologymoney))
        content4.add(bookChild(4,R.drawable.richdad))
        content4.add(bookChild(4,R.drawable.atomichabits))

        val content5 = ArrayList<bookChild>()
        content5.add(bookChild(5,R.drawable.winfriends))
        content5.add(bookChild(5,R.drawable.pyschologymoney))
        content5.add(bookChild(5,R.drawable.richdad))
        content5.add(bookChild(5,R.drawable.atomichabits))

        val content6 = ArrayList<bookChild>()
        content6.add(bookChild(6,R.drawable.winfriends))
        content6.add(bookChild(6,R.drawable.pyschologymoney))
        content6.add(bookChild(6,R.drawable.richdad))
        content6.add(bookChild(6,R.drawable.atomichabits))



        val allCategory = ArrayList<BookParent>()
        allCategory.add(BookParent("TRENDING",content1))
        allCategory.add(BookParent("EDITORS CHOICE",content2))
        allCategory.add(BookParent("TOP SELLER",content3))
        allCategory.add(BookParent("SELF GROWTH",content4))
        allCategory.add(BookParent("BEST SELLER",content5))
        allCategory.add(BookParent("TOP TODAY",content6))

        setMainRecycler(allCategory,content1)
    }

    private  fun setMainRecycler(category:List<BookParent>,content:List<bookChild>){
        mainRecyclerView = findViewById(R.id.mainRecyclerView)
        val layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        mainRecyclerView!!.layoutManager = layoutManager
        mainAdapter = ParentAdapter(this,category)
        mainRecyclerView.adapter = mainAdapter

    }
}