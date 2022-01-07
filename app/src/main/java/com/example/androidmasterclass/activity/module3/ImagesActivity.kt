package com.example.androidmasterclass.activity.module3

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
import com.facebook.drawee.backends.pipeline.Fresco
import android.net.Uri
import androidx.fragment.app.FragmentActivity

import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.drawee.interfaces.DraweeController

import com.facebook.imagepipeline.request.ImageRequest

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
        if(action.equals("simpleImage")) {
            showSimpleImage()
        } else {
            showFrescoImage()
        }
    }

    private fun showFrescoImage() {
        val draweeView = findViewById(R.id.simple_drawee_view) as SimpleDraweeView
        draweeView.visibility = View.VISIBLE
        draweeView.setImageURI("https://i.imgur.com/IJF8x9D.jpg")
    }

    private fun showSimpleImage() {
        var imageView = findViewById(R.id.image_view) as ImageView
        imageView.visibility = View.VISIBLE
        imageView.setImageResource(R.drawable.ic_overflow_holo_dark)
    }
}