package com.toyproject.petpick.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toyproject.petpick.R
import com.toyproject.petpick.databinding.BreedInfoItemBinding

class InfoAdapter(private val title : List<String>, private val context : List<String>)
    : RecyclerView.Adapter<InfoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.breed_info_item, parent, false)
        return ViewHolder(BreedInfoItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.title.text = title[position]
        holder.binding.context.text = context[position]

        Log.d("InfoAdapter", "title$position : ${title[position]}\n context$position : ${context[position]}")
    }

    override fun getItemCount(): Int {
        return title.size
    }


        inner class ViewHolder(val binding: BreedInfoItemBinding) : RecyclerView.ViewHolder(binding.root)
}