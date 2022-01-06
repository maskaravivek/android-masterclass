package com.example.androidmasterclass.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidmasterclass.R

class BottomTabFragment : Fragment(R.layout.fragment_bottom_tab) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tabName = requireArguments().getString("tabName")

        val messageTextView = getView()?.findViewById(R.id.message) as TextView
        messageTextView.text = tabName
    }
}