package com.mbobiosio.rxjavasearchkotlin.ui.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import com.mbobiosio.rxjavasearchkotlin.R
import com.mbobiosio.rxjavasearchkotlin.model.DataModel
import kotlinx.android.synthetic.main.item_cars.view.*
import java.util.*
import kotlin.collections.ArrayList


class AutomobilesAdapter(
    private var dataList: List<DataModel>
) : RecyclerView.Adapter<AutomobilesAdapter.AutomobileVH>(), Filterable {

    var filteredList: List<DataModel> = dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutomobileVH {
        return AutomobileVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cars, parent, false)
        )
    }

    override fun getItemCount() = filteredList.size

    override fun onBindViewHolder(holder: AutomobileVH, position: Int) = holder.bind(filteredList[position])

    class AutomobileVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: DataModel) = with(itemView) {

            company.text = data.brand
            country.text = data.country

            setOnClickListener {
                Toast.makeText(itemView.context, "${data.brand} - ${data.country}", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()

                filteredList = when {
                    charString.isEmpty() -> dataList
                    else -> {
                        val internalFilteredList: MutableList<DataModel> = mutableListOf()
                        for (data in dataList) {
                            if (data.brand.contains(charString, ignoreCase = true)
                                || data.country.contains(charString, ignoreCase = true)) {
                                internalFilteredList.add(data)
                            }
                        }
                        internalFilteredList
                    }
                }

                val filteredResults = FilterResults()
                filteredResults.values = filteredList
                return filteredResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                filteredList = p1?.values as List<DataModel>
                notifyDataSetChanged()
            }

        }
    }

}