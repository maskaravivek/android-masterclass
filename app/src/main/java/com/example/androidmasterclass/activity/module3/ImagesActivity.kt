package com.example.androidmasterclass.activity.module3

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import java.net.URL


class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_images)
        displayMenuBasedOnAction()
    }

    private fun displayMenuBasedOnAction() {
        val extras = intent.extras
        if (extras == null) {
            return
        }
        val action = extras?.getString("action")
        if (action.equals("simpleImage")) {
            showSimpleImage()
        } else if (action.equals("bitmapImage")) {
            showBitmapImage()
        } else if (action.equals("frescoImage")) {
            showFrescoImage()
        }
    }

    private fun showFrescoImage() {
        val draweeView = findViewById(R.id.simple_drawee_view) as SimpleDraweeView
        draweeView.visibility = View.VISIBLE
        draweeView.setImageURI("https://i.imgur.com/IJF8x9D.jpg")
    }

    private fun showBitmapImage() {
        var imageView = findViewById(R.id.image_view) as ImageView
        imageView.visibility = View.VISIBLE
        val url = URL("https://i.imgur.com/IJF8x9D.jpg")
        Thread {
            val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            runOnUiThread({
                imageView.setImageBitmap(bmp)
            })
        }.start()
    }

    private fun showSimpleImage() {
        var imageView = findViewById(R.id.image_view) as ImageView
        imageView.visibility = View.VISIBLE
        imageView.setImageResource(R.drawable.ic_overflow_holo_dark)
    }
}