package com.example.bookflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import android.widget.TextView
import android.media.MediaPlayer
import android.widget.Button
import android.widget.Toast
import java.util.concurrent.TimeUnit

class MediaPlayer : AppCompatActivity() {
    var oneTimeOnly =0
    var startTime =0.0
    var finalTime =0.0
    var forwardTime=10000
    var backwardTime =10000

    //Handler
    var handler:Handler = Handler()

    //mediaPlayer
    var mediaPlayer = MediaPlayer()


    //seekbar
    lateinit var seekBar: SeekBar
    lateinit var time_left:TextView
    lateinit var title_track:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        //declaring variables
        val forwardButton = findViewById<Button>(R.id.forward_btn)
        val backwardButton = findViewById<Button>(R.id.backward_btn)
        val playButton = findViewById<Button>(R.id.play_btn)
        val pauseButton = findViewById<Button>(R.id.pause_btn)

        title_track = findViewById(R.id.audio_title)
        time_left = findViewById(R.id.time_left)
        seekBar = findViewById(R.id.seekbar)


        //creating media player
        mediaPlayer = MediaPlayer.create(this,R.raw.letmedownslowly)



        //play button
        playButton.setOnClickListener {
            mediaPlayer.start()
            startTime=mediaPlayer.currentPosition.toDouble()
            finalTime=mediaPlayer.duration.toDouble()

            if(oneTimeOnly==0){
                seekBar.max=finalTime.toInt()
                oneTimeOnly=1
            }
            time_left.text = startTime.toString()

            seekBar.setProgress(startTime.toInt())
            handler.postDelayed(updateSongTime,100)

        }

        //pause button
        pauseButton.setOnClickListener {
            mediaPlayer.pause()
        }


        //forward button
        forwardButton.setOnClickListener {
            val temp=startTime
            if((temp+forwardTime)<=finalTime){
                startTime =startTime+forwardTime
                mediaPlayer.seekTo(startTime.toInt())
            }else{
                Toast.makeText(this,"Can't forward",Toast.LENGTH_SHORT).show()
            }

        }

        //backward button
        backwardButton.setOnClickListener {
            val temp =startTime
            if((temp-backwardTime)>0){
                startTime =startTime-backwardTime
                mediaPlayer.seekTo(startTime.toInt())
            }else{
                Toast.makeText(this,"Can't backward",Toast.LENGTH_SHORT).show()
            }
        }


    }

    val updateSongTime :Runnable = object :Runnable{
        override fun run() {
            startTime=mediaPlayer.currentPosition.toDouble()
            time_left.text = String.format("%d min,%d sec",TimeUnit.MILLISECONDS.toMinutes(startTime.toLong()),
                (TimeUnit.MILLISECONDS.toSeconds(
                    startTime.toLong())-(TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(startTime.toLong()))
                        )))

            seekBar.progress =startTime.toInt()
            handler.postDelayed(this,100)
        }

    }


}
