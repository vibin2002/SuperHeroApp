package com.killerinstinct.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.killerinstinct.superheroapp.data.HeroResponse
import com.killerinstinct.superheroapp.databinding.ActivityStatsBinding

class StatsActivity : AppCompatActivity() {

    lateinit var binding: ActivityStatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getSerializableExtra("Hero") as HeroResponse

        Glide.with(this).load(hero.images!!.sm).into(binding.saHeroImage)

//        binding.progressBar.apply {
//            progress = hero.powerstats?.intelligence!!
//        }


    }
}