package com.educative.android.hello.activity.module9

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.educative.android.hello.adapters.RecyclerViewAdapter
import com.example.educative.hello.R
import com.educative.android.hello.interfaces.CountryListInterface
import com.educative.android.hello.models.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Lesson1RetrofitActivity : AppCompatActivity() {

    var dataset: ArrayList<String> = arrayListOf()
    lateinit var adapter: RecyclerViewAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_9_lesson_1_retrofit)
        setRecyclerView()
        getCountryList()
    }

    private fun setRecyclerView() {
        adapter = RecyclerViewAdapter(dataset)
        val layoutManager = LinearLayoutManager(applicationContext)
        var recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun getCountryList() {
        val button = findViewById<Button>(R.id.retrofit_get_api)
        button.setOnClickListener {
            getCountryListFromAPI()
            Log.d("Lesson1RetrofitActivity", "button clicked")
        }
    }

    private fun getCountryListFromAPI() {
        val apiInterface = CountryListInterface.create().getCountries()

        apiInterface.enqueue(object : Callback<List<Country>> {
            override fun onResponse(
                call: Call<List<Country>>?,
                response: Response<List<Country>>?
            ) {
                Log.d("Lesson1RetrofitActivity", response!!.body().toString())

                if (response?.body() != null) {
                    Log.d("Lesson1RetrofitActivity", "setting body")
                    response.body()!!.forEach {
                        dataset.add(it.name!!)
                    }
                    adapter.notifyDataSetChanged()
                    Log.d("Lesson1RetrofitActivity", dataset.toString())
                }
            }

            override fun onFailure(call: Call<List<Country>>?, t: Throwable?) {
                Log.d("Lesson1RetrofitActivity", t.toString())
                Toast.makeText(
                    baseContext, "Error occurred!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}