package com.demo.kotlindemo

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // finding the textView
        var textView = findViewById(R.id.txtView) as TextView
        var imageView = findViewById(R.id.imageView) as ImageView

        //With Coroutines
        textView.visibility = View.VISIBLE
        imageView.visibility=View.GONE

        repeat(10_000){
        GlobalScope.launch {

                        delay(10000L)

                        withContext(Dispatchers.Main){
                            textView.setText(""+ Math.random())
                        }
                    }

        }

        //Without Coroutines
      /*  textView.visibility = View.VISIBLE
        imageView.visibility=View.GONE


        repeat(10_000){
         thread {

                    Thread.sleep(5000L)
                    runOnUiThread {
                        textView.setText(""+ Math.random())
                    }

                }
            }*/


        //Loading network image using Coroutine

        /*textView.visibility = View.GONE
        imageView.visibility=View.VISIBLE

        GlobalScope.launch(Dispatchers.IO) {

            val imageUrl = URL("https://developer.android.com/images/kotlin/cards/kotlin-bootcamp.png")

            val httpConnection = imageUrl.openConnection() as HttpURLConnection
            httpConnection.doInput = true
            httpConnection.connect()

            val inputStream = httpConnection.inputStream
            val bitmapImage = BitmapFactory.decodeStream(inputStream)

            launch(Dispatchers.Main) {
                imageView.setImageBitmap(bitmapImage)
            }
        }*/
    }
    }

