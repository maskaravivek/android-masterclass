package com.educative.android.hello.activity.module10

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.educative.android.hello.repository.MyPaymentHelper
import com.example.educative.hello.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Lesson2HiltExampleActivity : AppCompatActivity() {

    var counter = 100

    @Inject
    lateinit var myPaymentHelper: MyPaymentHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_10_lesson_2_hilt_example)
        attachButtonHandlers()
    }

    private fun attachButtonHandlers() {
        val makePayment = findViewById<Button>(R.id.make_payment)
        makePayment.setOnClickListener {
            try {
                val amountStr = findViewById<EditText>(R.id.payment_amount).text.toString()
                val amount = amountStr.toInt()
                counter += 1
                myPaymentHelper.makePayment(counter.toString(), amount)

                val paymentIdTv = findViewById<TextView>(R.id.payment_id)
                paymentIdTv.text = "Payment ID: $counter"

                var receiptNum = findViewById<EditText>(R.id.payment_receipt_id)
                receiptNum.setText(counter.toString())
            } catch (ex: Exception) {
                Toast.makeText(
                    this,
                    "Error occurred. Make sure amount is a valid integer.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        val fetchPayment = findViewById<Button>(R.id.fetch_payment)
        fetchPayment.setOnClickListener {
            try {
                val receiptNum = findViewById<EditText>(R.id.payment_receipt_id).text.toString()
                val amount = myPaymentHelper.getPaymentAmount(receiptNum)

                val paymentAmountTv = findViewById<TextView>(R.id.payment_amount_tv)
                paymentAmountTv.text = "Payment amount: $amount"
            } catch (ex: Exception) {
                Toast.makeText(
                    this,
                    "Error occurred. Make sure receipt ID is valid.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}