package com.killerinstinct.superheroapp

import android.content.res.ColorStateList
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.transition.Fade
import android.util.Log
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
        print("$hero qwerty")
        val palette = intent.getIntExtra("pallete",Color.RED)
        val gd = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(-0xececed,palette,palette,palette)
        )
        window.statusBarColor = Color.BLACK
        gd.cornerRadius = 0f


        Glide.with(this).load(hero.images!!.sm).into(binding.saHeroImage)
        binding.consLayout.background = gd



        binding.apply {

            Log.d( "ProgressDF",hero.powerstats.toString())

            tempprog.progress = hero.powerstats?.combat ?: 0

            saHeroName.text= hero.name
            saHeroName.setTextColor(palette)

            pbCombat.max = 100
            pbCombat.progress = hero.powerstats?.combat ?: 10

            pbDurability.max = 100
            pbDurability.progress = hero.powerstats?.durability ?: 0

            pbIntelligence.max = 100
            pbIntelligence.progress = hero.powerstats?.intelligence ?: 0

            pbPower.max = 100
            pbPower.progress = hero.powerstats?.power ?: 0


            pbSpeed.max = 100
            pbSpeed.progress = hero.powerstats?.speed ?: 0

            pbStrength.max = 100
            pbStrength.progress = hero.powerstats?.strength ?: 0


            tvHeight.text = hero.appearance?.height?.get(1).toString()
            tvWeight.text = hero.appearance?.weight?.get(1).toString()

        }

        window.enterTransition = Fade()
    }


}