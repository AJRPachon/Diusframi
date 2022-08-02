package com.example.diusframi.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.diusframi.R
import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.databinding.HomeHerollainsRowBinding

class HerollainAdapter(val listener : HerollainCallBack.HerollainDetailClickListener) : ListAdapter<HerollainBo, HerollainAdapter.HerollainViewHolder>(HerollainCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HerollainViewHolder =
        HerollainViewHolder(HomeHerollainsRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))


    override fun onBindViewHolder(holder: HerollainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class HerollainViewHolder(private val binding: HomeHerollainsRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(herollainBo: HerollainBo){
                binding.homeRowLblHerollainNameValue.text = herollainBo.name ?: ""

                binding.homeRowLblHerollainIntelligenceValue.text = herollainBo.powerstats?.intelligence?.toString() ?: ""
                binding.homeRowLblHerollainStrengthValue.text = herollainBo.powerstats?.strength?.toString() ?: ""
                binding.homeRowLblHerollainSpeedValue.text = herollainBo.powerstats?.speed?.toString() ?: ""
                binding.homeRowLblHerollainDurabilityValue.text = herollainBo.powerstats?.durability?.toString() ?: ""
                binding.homeRowLblHerollainPowerValue.text = herollainBo.powerstats?.power ?.toString() ?: ""
                binding.homeRowLblHerollainCombatValue.text = herollainBo.powerstats?.combat?.toString() ?: ""

                Glide.with(itemView.context)
                    .load(herollainBo.images?.lg)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.homeRowImgHerollainProfilePic)

                if(herollainBo.isFavorite == true){
                    Glide.with(itemView.context)
                        .load(R.drawable.ic__isfavourite)
                        .error(R.drawable.ic__isnofavourite)
                        .into(binding.homeRowImgIsFavourite)
                } else {
                    binding.homeRowImgIsFavourite.visibility = View.GONE
                }

                binding.homeRowContainer.setOnClickListener {
                    herollainBo.id?.let { id -> listener.onHerollainClicked(id) }
                }
            }
    }

}

class HerollainCallBack : DiffUtil.ItemCallback<HerollainBo>() {
    override fun areItemsTheSame(oldItem: HerollainBo, newItem: HerollainBo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HerollainBo, newItem: HerollainBo): Boolean {
        return oldItem == newItem
    }


    interface HerollainDetailClickListener {
        fun onHerollainClicked(herollainId : Int)
    }
}