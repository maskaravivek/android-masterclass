package com.example.androidmasterclass.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CustomDialogFragment1 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Are you enjoying this course?")
                .setPositiveButton("Yes",
                    { dialog, id ->
                        // Positive action handler
                    })
                .setNegativeButton("No",
                    { dialog, id ->
                        // Negative action handler
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {
        const val TAG = "CustomDialogFragment1"
    }
}