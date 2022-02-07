package com.example.androidmasterclass.activity.module3;

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
import com.example.androidmasterclass.fragments.CustomDialogFragment1
import com.example.androidmasterclass.fragments.CustomDialogFragment2

class Lesson2DialogActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson_2_dialog)
        addSimpleDialogAlertHandler()
        addActionDialogAlertHandler()
        addCustomDialogFragment1Handler()
        addCustomDialogFragment2Handler()
    }

    private fun addSimpleDialogAlertHandler(){
        // get reference to button
        val btn_click_me = findViewById(R.id.dialog_button_simple) as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("Simple alert!")
                .setMessage("This is a alert dialog!")
                .show()
        }
    }

    private fun addActionDialogAlertHandler(){
        // get reference to button
        val btn_click_me=findViewById(R.id.dialog_button_with_actions)as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("Action Dialog!")
                .setMessage("Do you confirm this action?")
                .setPositiveButton("Confirm"){_,_->
                    val statusText=findViewById(R.id.status_text)as TextView
                    statusText.setText("Status Updated")
                }
                .show()
        }
    }

    private fun addCustomDialogFragment1Handler(){
        // get reference to button
        val btn_click_me=findViewById(R.id.custom_dialog_button_1)as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            CustomDialogFragment1().show(
                supportFragmentManager,CustomDialogFragment1.TAG)
        }
    }

    private fun addCustomDialogFragment2Handler(){
        // get reference to button
        val btn_click_me=findViewById(R.id.custom_dialog_button_2)as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            CustomDialogFragment2().show(
                supportFragmentManager,CustomDialogFragment2.TAG)
        }
    }
}
