package com.example.diusframi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.diusframi.R
import com.example.diusframi.data.entities.bo.HerollainsBo
import com.example.diusframi.databinding.HomeHerollainsRowBinding

class HerollainsAdapter : ListAdapter<HerollainsBo, HerollainsAdapter.HerollainsViewHolder>(HerollainsCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HerollainsViewHolder =
        HerollainsViewHolder(HomeHerollainsRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))


    override fun onBindViewHolder(holder: HerollainsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class HerollainsViewHolder(private val binding: HomeHerollainsRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(herollainsBo: HerollainsBo){
                binding.homeRowLblHerollainNameValue.text = herollainsBo.name ?: ""

                binding.homeRowLblHerollainIntelligenceValue.text = herollainsBo.powerstats?.intelligence?.toString() ?: ""
                binding.homeRowLblHerollainStrengthValue.text = herollainsBo.powerstats?.strength?.toString() ?: ""
                binding.homeRowLblHerollainSpeedValue.text = herollainsBo.powerstats?.speed?.toString() ?: ""
                binding.homeRowLblHerollainDurabilityValue.text = herollainsBo.powerstats?.durability?.toString() ?: ""
                binding.homeRowLblHerollainPowerValue.text = herollainsBo.powerstats?.power ?.toString() ?: ""
                binding.homeRowLblHerollainCombatValue.text = herollainsBo.powerstats?.combat?.toString() ?: ""

                Glide.with(itemView.context)
                    .load(herollainsBo.urls?.lg)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.homeRowImgHerollainProfilePic)

                if(herollainsBo.isFavorite == true){
                    Glide.with(itemView.context)
                        .load(R.drawable.ic__isfavourite)
                        .error(R.drawable.ic__isnofavourite)
                        .into(binding.homeRowImgIsFavourite)
                } else {
                    Glide.with(itemView.context)
                        .load(R.drawable.ic__isnofavourite)
                        .error(R.drawable.ic__isnofavourite)
                        .into(binding.homeRowImgIsFavourite)
                }
            }
    }

}

class HerollainsCallBack : DiffUtil.ItemCallback<HerollainsBo>() {
    override fun areItemsTheSame(oldItem: HerollainsBo, newItem: HerollainsBo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HerollainsBo, newItem: HerollainsBo): Boolean {
        return oldItem == newItem
    }

}