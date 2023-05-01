package com.example.bookflip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val image = findViewById<ImageView>(R.id.displayImage)
        val bundle:Bundle?= intent.extras
        val img = bundle?.get("imageData")
        val id = bundle?.get("id")

        var bookid1 = when(id){
            "2131165340" -> 1
            "2131165416" -> 2
            "2131165415" -> 3
            "2131165420" -> 4
            else -> 0}



        image.setImageResource(img as Int)
        Toast.makeText(this@DescriptionActivity,"$id",Toast.LENGTH_SHORT).show()
        //play button
        val playButton = findViewById<Button>(R.id.playButton)
        playButton.setOnClickListener {
            val intent = Intent(this,MediaPlayer::class.java)
            intent.putExtra("id", bookid1)
            startActivity(intent)
        }

        val readButton = findViewById<Button>(R.id.ReadButton)
        readButton.setOnClickListener {
            val i :Intent = Intent(this,PdfActivity::class.java)
            i.putExtra("id", bookid1)
            startActivity(i)
        }

        val descriptionOfBooks = mutableListOf<String>("Coming Soon with description.",getString(R.string.ikigai_description),getString(R.string.rich_dad_poor_dad_description),getString(R.string.psychology_of_money_description),getString(R.string.how_to_win_friends_description))
        var descriptionTextView: TextView = findViewById(R.id.description_textview)
        descriptionTextView.setText(descriptionOfBooks[bookid1])

    }
}