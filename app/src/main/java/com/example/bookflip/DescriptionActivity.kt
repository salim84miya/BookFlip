package com.example.bookflip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val image = findViewById<ImageView>(R.id.displayImage)
        val bundle:Bundle?= intent.extras
        val img = bundle?.get("imageData")
        val id = bundle?.get("id")

        image.setImageResource(img as Int)
        Toast.makeText(this@DescriptionActivity,"$id",Toast.LENGTH_SHORT).show()
        //play button
        val playButton = findViewById<Button>(R.id.playButton)
        playButton.setOnClickListener {
            val intent = Intent(this,MediaPlayer::class.java)
            startActivity(intent)
        }

        val readButton = findViewById<Button>(R.id.ReadButton)
        readButton.setOnClickListener {
            val i :Intent = Intent(this,PdfActivity::class.java)
            startActivity(i)
        }

    }
}