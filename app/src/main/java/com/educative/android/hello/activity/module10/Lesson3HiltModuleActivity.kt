package com.educative.android.hello.activity.module10

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.educative.android.hello.adapters.RecyclerViewAdapter
import com.educative.android.hello.interfaces.CountryListHiltInterface
import com.example.educative.hello.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class Lesson3HiltModuleActivity : AppCompatActivity() {

    @Inject lateinit var countryListInterface: CountryListHiltInterface;

    var dataset: ArrayList<String> = arrayListOf()
    lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_10_lesson_3_hilt_module)
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
            Log.d("Lesson3HiltModuleActivity", "button clicked")
        }
    }

    private fun getCountryListFromAPI() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = countryListInterface.getCountries()
            response.body()!!.forEach {
                dataset.add(it.name!!)
            }
            withContext(Dispatchers.Main) {
                adapter.notifyDataSetChanged()
            }
        }
    }
}