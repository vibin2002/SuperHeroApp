package com.killerinstinct.superheroapp

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.transition.Fade
import androidx.appcompat.app.AppCompatActivity
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
        val palette = intent.getIntExtra("pallete",Color.RED)
        val gd = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(palette, -0xececed)
        )

        window.statusBarColor = palette
        gd.cornerRadius = 0f


        Glide.with(this).load(hero.images!!.sm).into(binding.saHeroImage)

        binding.consLayout.background = gd



        window.enterTransition = Fade()
    }
}