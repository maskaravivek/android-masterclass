package com.example.androidmasterclass.activity.module5

import android.graphics.Bitmap
import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.androidmasterclass.R
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream
import java.io.File

class Lesson3FirebaseStorage : AppCompatActivity() {

    private lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_5_lesson3_firebase_storage)
        storage = FirebaseStorage.getInstance()
        uploadFromInMemory()
        downloadFileFromStorage()
    }

    private fun uploadFromInMemory() {
        val button = findViewById<Button>(R.id.upload_from_in_memory)
        button.setOnClickListener {
            uploadFromDataInMemory()
        }
    }

    private fun downloadFileFromStorage() {
        val button = findViewById<Button>(R.id.download_file)
        button.setOnClickListener {
            downloadFile()
        }
    }

    private fun uploadFromDataInMemory() {
        val storageRef = storage.reference
        val appIconRef = storageRef.child("app_icon.jpg")

        val imageView = findViewById<ImageView>(R.id.image_view)
        val bitmap = (imageView.drawable as VectorDrawable).toBitmap()
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

    private fun downloadFile() {
        val storageRef = storage.reference
        val ref = storageRef.child("app_icon.jpg")

        val localFile = File.createTempFile("images", "jpg")

        ref.getFile(localFile).addOnSuccessListener {
            Toast.makeText(
                this, "Download successful.",
                Toast.LENGTH_LONG
            ).show()
        }.addOnFailureListener {
            Toast.makeText(
                this, "Download failed",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}