package com.mbobiosio.rxjavasearchkotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.mbobiosio.rxjavasearchkotlin.R
import com.mbobiosio.rxjavasearchkotlin.model.DataModel
import com.mbobiosio.rxjavasearchkotlin.ui.adapter.AutomobilesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: AutomobilesAdapter
    private val mItemsList: ArrayList<DataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initItems()

        mItemsList.shuffle()

        mAdapter = AutomobilesAdapter(mItemsList)
        list.adapter = mAdapter

    }

    private fun initItems() {
        mItemsList.add(DataModel("Mercedes Benz", "Germany"))
        mItemsList.add(DataModel("Volkswagen", "Germany"))
        mItemsList.add(DataModel("Maybach", "Germany"))
        mItemsList.add(DataModel("BMW", "Germany"))
        mItemsList.add(DataModel("Audi", "Germany"))
        mItemsList.add(DataModel("Smart", "Germany"))
        mItemsList.add(DataModel("Porsche", "Germany"))
        mItemsList.add(DataModel("Opel", "Germany"))
        mItemsList.add(DataModel("Cadillac", "United States"))
        mItemsList.add(DataModel("Chevrolet", "United States"))
        mItemsList.add(DataModel("Chrysler", "United States"))
        mItemsList.add(DataModel("Dodge", "United States"))
        mItemsList.add(DataModel("Ford", "United States"))
        mItemsList.add(DataModel("GMC", "United States"))
        mItemsList.add(DataModel("Jeep", "United States"))
        mItemsList.add(DataModel("Tesla-EV", "United States"))
        mItemsList.add(DataModel("Lincoln", "United States"))
        mItemsList.add(DataModel("Aston Martin", "United Kingdom"))
        mItemsList.add(DataModel("Bentley", "United Kingdom"))
        mItemsList.add(DataModel("Jaguar", "United Kingdom"))
        mItemsList.add(DataModel("Land-Rover", "United Kingdom"))
        mItemsList.add(DataModel("Leyland", "United Kingdom"))
        mItemsList.add(DataModel("Rolls-Royce", "United Kingdom"))
        mItemsList.add(DataModel("Vauxhall", "United Kingdom"))
        mItemsList.add(DataModel("McLaren", "United Kingdom"))
        mItemsList.add(DataModel("MINI", "United Kingdom"))
        mItemsList.add(DataModel("Morgan", "United Kingdom"))
        mItemsList.add(DataModel("Abarth", "Italy"))
        mItemsList.add(DataModel("Lamborghini", "Italy"))
        mItemsList.add(DataModel("Maserati", "Italy"))
        mItemsList.add(DataModel("Acura", "Japan"))
        mItemsList.add(DataModel("Daihatsu", "Japan"))
        mItemsList.add(DataModel("Honda", "Japan"))
        mItemsList.add(DataModel("infinity", "Japan"))
        mItemsList.add(DataModel("Izuzu", "Japan"))
        mItemsList.add(DataModel("Lexus", "Japan"))
        mItemsList.add(DataModel("Mazda", "Japan"))
        mItemsList.add(DataModel("Toyota", "Japan"))
        mItemsList.add(DataModel("Subaru", "Japan"))
        mItemsList.add(DataModel("Nissan", "Japan"))
        mItemsList.add(DataModel("Mitsubishi", "Japan"))
        mItemsList.add(DataModel("Innoson", "Nigeria"))
        mItemsList.add(DataModel("Aurus", "Russia"))
        mItemsList.add(DataModel("Lada", "Russia"))
        mItemsList.add(DataModel("Bugatti", "France"))
        mItemsList.add(DataModel("Citroen", "France"))
        mItemsList.add(DataModel("Peugeot", "France"))
        mItemsList.add(DataModel("Renault", "France"))
        mItemsList.add(DataModel("GAC", "China"))
        mItemsList.add(DataModel("BAIC", "China"))
        mItemsList.add(DataModel("Chana", "China"))
        mItemsList.add(DataModel("Changfeng", "China"))
        mItemsList.add(DataModel("Chery", "China"))
        mItemsList.add(DataModel("Dongfeng", "China"))
        mItemsList.add(DataModel("GreatWall", "China"))
        mItemsList.add(DataModel("Hafei", "China"))
        mItemsList.add(DataModel("Wuling", "China"))
        mItemsList.add(DataModel("Saab", "Sweden"))
        mItemsList.add(DataModel("Scania", "Sweden"))
        mItemsList.add(DataModel("Koenigsegg", "Sweden"))
        mItemsList.add(DataModel("Volvo", "Sweden"))
        mItemsList.add(DataModel("Tata", "India"))
        mItemsList.add(DataModel("Mahindra", "India"))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val menuItem = menu?.findItem(R.id.search)
        val searchView: SearchView = menuItem?.actionView as SearchView

        performSearch(searchView)

        return super.onCreateOptionsMenu(menu)
    }

    private fun performSearch(searchView: SearchView) {

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //Log.d("TAG", "Text $newText")
                mAdapter.filter.filter(newText)

                return true
            }


        })

    }

}