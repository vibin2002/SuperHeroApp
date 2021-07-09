package com.killerinstinct.superheroapp.adapters

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.killerinstinct.superheroapp.StatsActivity
import com.killerinstinct.superheroapp.data.HeroResponse
import com.killerinstinct.superheroapp.databinding.HeroCardBinding

class HeroAdapter(
    var heroes: List<HeroResponse>,
    private val onHeroItemClickListener: OnHeroItemClickListener
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
            Glide.with(holder.itemView)
                .load(heroes[position].images?.sm)
                .into(heroImage)
            heroName.text = heroes[position].name
            val hero = heroes[position]
            heroImage.setOnClickListener {
                onHeroItemClickListener.onClick(position,hero,binding = holder.binding)

            }
        }
    }

    override fun getItemCount() = heroes.size

    inner class HeroViewHolder(
        val binding: HeroCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
    }


    interface OnHeroItemClickListener    {
        fun onClick(position: Int,heroResponse: HeroResponse,binding: HeroCardBinding)
    }

}