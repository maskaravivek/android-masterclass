package com.educative.android.hello.activity.module9

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.educative.hello.R
import com.educative.android.hello.interfaces.CatInterface
import com.educative.android.hello.models.CatFact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Lesson1RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_9_lesson_1_retrofit)
        getCatFacts()
    }

    private fun getCatFacts() {
        val button = findViewById<Button>(R.id.retrofit_get_api)
        button.setOnClickListener {
            getCatFactsFromAPI()
        }
    }

    private fun getCatFactsFromAPI() {
        val apiInterface = CatInterface.create().getFacts()

        apiInterface.enqueue(object : Callback<List<CatFact>> {
            override fun onResponse(
                call: Call<List<CatFact>>?,
                response: Response<List<CatFact>>?
            ) {

                if (response?.body() != null) {
                    Toast.makeText(
                        baseContext, "Fetched ${response.body()!!.size} cat facts",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<CatFact>>?, t: Throwable?) {
                Toast.makeText(
                    baseContext, "Error occurred!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}