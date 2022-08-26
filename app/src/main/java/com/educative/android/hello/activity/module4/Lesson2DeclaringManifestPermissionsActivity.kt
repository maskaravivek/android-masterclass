package com.educative.android.hello.activity.module4

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.educative.hello.R
import java.net.URL


class Lesson2DeclaringManifestPermissionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_4_lesson_2_manifest_permissions)
        attachEvents()
    }

    private fun attachEvents() {
        val button1 = findViewById<Button>(R.id.load_internet_image)
        button1.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.INTERNET
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                val imageView = findViewById<ImageView>(R.id.internet_image_view)

                val url = URL("https://www.maskaravivek.com/project/word-a-day/featured.png")
                Thread {
                    val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                    runOnUiThread {
                        imageView.setImageBitmap(bmp)
                    }
                }.start()
            } else {
                Toast.makeText(
                    this,
                    "Internet required. Add internet permission to AndroidManifest.xml",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}