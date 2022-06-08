package com.example.androidmasterclass.activity.module4

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.androidmasterclass.R


class Lesson3RuntimePermissionsActivity : AppCompatActivity() {

    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_4_lesson_3_runtime_permissions)
        attachEvents()
    }

    private fun attachEvents() {
        requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    // Perform action
                } else {
                    // show appropriate message to the user
                }
            }
        val button1 = findViewById<Button>(R.id.write_external_storage)
        button1.setOnClickListener {
            requestPermissionAndWriteFileToExternalStorage()
        }

        val button2 = findViewById<Button>(R.id.read_external_storage)
        button2.setOnClickListener {
            requestPermissionAndReadFileFromExternalStorage()
        }
    }

    private fun requestPermissionAndWriteFileToExternalStorage() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // perform action
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                //show alert dialog and request permission if user clicks yes.
                showAlertDialog()
            } else {
                requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
    }

    private fun requestPermissionAndReadFileFromExternalStorage() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // perform action
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                //show alert dialog and request permission if user clicks yes.
                showAlertDialog()
            } else {
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("External storage")
            .setMessage("We require external storage permissions to read and write file.")
            .setPositiveButton("Yes, go ahead") { _, _ ->
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }.setNegativeButton("No, cancel") { _, _ ->
                //do nothing
            }
            .show()
    }
}