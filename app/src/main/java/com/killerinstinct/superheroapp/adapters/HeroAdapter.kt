package com.killerinstinct.superheroapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.killerinstinct.superheroapp.R
import com.killerinstinct.superheroapp.data.HeroResponse
import com.killerinstinct.superheroapp.databinding.HeroCardBinding

class HeroAdapter(
    var heroes: List<HeroResponse>,
) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(
            HeroCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.binding.apply {
//            heroImage.setImageResource(R.drawable.doctoroctopus)
            Glide.with(holder.itemView)
                .load(heroes[position].images?.sm)
                .into(heroImage)
            heroName.text = heroes[position].name
        }
    }

    override fun getItemCount() = heroes.size


    inner class HeroViewHolder(val binding: HeroCardBinding) :
        RecyclerView.ViewHolder(binding.root)
}