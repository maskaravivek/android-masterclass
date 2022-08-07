package com.example.androidmasterclass.activity.module4

import android.Manifest
import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.androidmasterclass.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File


class Lesson3RuntimePermissionsActivity : AppCompatActivity() {

    private lateinit var requestPermissionWriteLauncher: ActivityResultLauncher<String>
    private lateinit var requestPermissionReadLauncher: ActivityResultLauncher<String>
    private var filePath: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_4_lesson_3_runtime_permissions)
        attachEvents()
    }

    private fun attachEvents() {
        requestPermissionWriteLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    // Perform action
                    writeToExternalStorage()
                } else {
                    // show appropriate message to the user
                    Toast.makeText(
                        this,
                        "Storage permission not granted!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        requestPermissionReadLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    // Perform action
                    readFromExternalStorage()
                } else {
                    // show appropriate message to the user
                    Toast.makeText(
                        this,
                        "Storage permission not granted!",
                        Toast.LENGTH_SHORT
                    ).show()
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
            writeToExternalStorage()
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                //show alert dialog and request permission if user clicks yes.
                showAlertDialog()
            } else {
                requestPermissionWriteLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
    }

    private fun requestPermissionAndReadFileFromExternalStorage() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            readFromExternalStorage()
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                //show alert dialog and request permission if user clicks yes.
                showAlertDialog()
            } else {
                requestPermissionReadLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("External storage")
            .setMessage("We require external storage permissions to read and write file.")
            .setPositiveButton("Yes, go ahead") { _, _ ->
                requestPermissionWriteLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }.setNegativeButton("No, cancel") { _, _ ->
                //do nothing
            }
            .show()
    }

    private fun writeToExternalStorage() {
        lifecycleScope.launch {
            val writeText = findViewById<EditText>(R.id.write_text_to_file)
            saveDocument(applicationContext, writeText.text.toString())
            Toast.makeText(applicationContext, "Written successfully!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun readFromExternalStorage() {
        lifecycleScope.launch {
            filePath?.let { it1 ->
                val data = read(applicationContext, it1)
                Toast.makeText(applicationContext, "File data is: $data ", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private suspend fun saveDocument(context: Context, text: String) {
        withContext(Dispatchers.IO) {
            val collection =
                MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
            val dirDest = File(
                Environment.DIRECTORY_DOCUMENTS,
                "Educative"
            )
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, "test.txt")
                put(
                    MediaStore.MediaColumns.RELATIVE_PATH,
                    "$dirDest${File.separator}"
                )
                put(MediaStore.Files.FileColumns.IS_PENDING, 1)
            }
            filePath = context.contentResolver.insert(collection, contentValues)
            withContext(Dispatchers.IO) {
                filePath?.let { uri ->
                    context.contentResolver.openOutputStream(uri, "w").use { out ->
                        out?.write(text.toByteArray())
                    }
                    contentValues.clear()
                    contentValues.put(MediaStore.Files.FileColumns.IS_PENDING, 0)
                    context.contentResolver.update(uri, contentValues, null, null)
                }
            }
        }
    }

    private suspend fun read(context: Context, source: Uri): String? = withContext(Dispatchers.IO) {
        val resolver: ContentResolver = context.contentResolver

        return@withContext resolver.openInputStream(source)
            ?.use { stream -> stream.readBytes().toString(Charsets.UTF_8) }
    }
}