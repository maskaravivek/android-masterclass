package com.example.androidmasterclass.activity.module5

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.androidmasterclass.R
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream

class Lesson3FirebaseStorage : AppCompatActivity() {

    private lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_5_lesson3_firebase_storage)
        storage = FirebaseStorage.getInstance()
        captureImage()
        uploadImage()
    }

    private val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.image_view)
            imageView.setImageBitmap(imageBitmap)
            val button = findViewById<Button>(R.id.upload_from_in_memory)
            button.isEnabled = true
        }
    }

    private fun captureImage() {
        val button = findViewById<Button>(R.id.capture_image)
        button.setOnClickListener {
            dispatchTakePictureIntent()
        }
    }

    private fun uploadImage() {
        val button = findViewById<Button>(R.id.upload_from_in_memory)
        button.setOnClickListener {
            uploadFromDataInMemory()
        }
    }

    private fun uploadFromDataInMemory() {
        val storageRef = storage.reference
        val appIconRef = storageRef.child("app_icon.jpg")

        val imageView = findViewById<ImageView>(R.id.image_view)
        val bitmap = (imageView.drawable as BitmapDrawable).toBitmap()
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = appIconRef.putBytes(data)
        uploadTask.addOnFailureListener {
            Toast.makeText(
                this, "Upload failed",
                Toast.LENGTH_LONG
            ).show()
        }.addOnSuccessListener {
            Toast.makeText(
                this, "Upload successful",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}