package com.toyproject.petpick.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.toyproject.petpick.R
import com.toyproject.petpick.data.RecommandListItem
import com.toyproject.petpick.databinding.BreedRecommendItemBinding
import kotlin.math.roundToInt

class RecommandAdapter(
    val recommandItem: List<RecommandListItem>,
    val onPercentButtonClickListener : OnPercentButtonClickListener)
    : RecyclerView.Adapter<RecommandAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.breed_recommend_item, parent, false)
        return ViewHolder(BreedRecommendItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.breedName.text = recommandItem[position].name
        holder.binding.week.text = recommandItem[position].week
        val percent = (recommandItem[position].percent * 10.0).roundToInt() /10.0
        holder.binding.percent.text = percent.toString() + "%"

        Glide
            .with(holder.binding.root)
            .load(recommandItem[position].image)
            .error(R.drawable.recommend)
            .into(holder.binding.breedImage)

        holder.binding.percent.setOnClickListener {
            onPercentButtonClickListener.OnPercentButtonClickListener(recommandItem[position])
        }
    }

    override fun getItemCount(): Int {
        return recommandItem.size
    }

    interface OnPercentButtonClickListener {
        fun OnPercentButtonClickListener(data: RecommandListItem)
    }

    inner class ViewHolder(val binding: BreedRecommendItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}