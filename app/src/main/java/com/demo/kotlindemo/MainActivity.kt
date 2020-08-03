package com.demo.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // finding the textView
        var textView = findViewById(R.id.txtView) as TextView

        //With Coroutines
      /*  GlobalScope.launch(Dispatchers.IO) {

                    repeat(10_000){
                        delay(1000L)

                        withContext(Dispatchers.Main){
                            textView.setText(""+ Math.random())
                        }
                    }

        }*/

        //Without Coroutines
        val mylamda = Thread({
            repeat (10_000){
                Thread.sleep(1000L)
              //  println("$x")
                runOnUiThread { textView.setText(""+ Math.random()) }

            }
        })
        startThread(mylamda)

    }
    }
fun startThread(mylamda: Thread) {
    mylamda.start()
}

