package com.educative.android.hello.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import com.example.educative.hello.R

class InfoView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {

        inflate(context, R.layout.info_view, this)

        val headingTextView: AppCompatTextView =
            findViewById(R.id.heading_text)

        val bodyTextView: AppCompatTextView =
            findViewById(R.id.body_text)

        val attributes =
            context.obtainStyledAttributes(
                attrs,
                R.styleable.InfoView
            )

        headingTextView.text = attributes.getString(
            R.styleable.InfoView_headingText
        )
        bodyTextView.text = attributes.getString(R.styleable.InfoView_bodyText)

        attributes.recycle()
    }
}