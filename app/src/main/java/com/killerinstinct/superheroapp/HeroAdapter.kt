package com.killerinstinct.superheroapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.killerinstinct.superheroapp.data.Hero
import com.killerinstinct.superheroapp.data.HeroResponse

class HeroAdapter(
    var heroes: List<HeroResponse>,
): RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    inner class HeroViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var image: ImageView = itemView.findViewById(R.id.hero_image)
        var name: TextView = itemView.findViewById(R.id.hero_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_card,parent,false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.apply {
            image.setImageResource(R.drawable.doctoroctopus)
            Glide.with(holder.itemView)
                .load(heroes[position].images?.sm)
                .into(image)
            name.text = heroes[position].name
        }
    }

    override fun getItemCount() = heroes.size

}