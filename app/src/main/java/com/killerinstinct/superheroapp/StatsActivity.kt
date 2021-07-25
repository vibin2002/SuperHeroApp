package com.killerinstinct.superheroapp

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.transition.Fade
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.killerinstinct.superheroapp.data.HeroResponse
import com.killerinstinct.superheroapp.databinding.ActivityStatsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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

            saHeroName.text= hero.name
            saHeroName.setTextColor(palette)

            tvHeight.text = hero.appearance?.height?.get(1).toString()
            tvWeight.text = hero.appearance?.weight?.get(1).toString()

            pbDurability.progress = 0
            pbDurability.progress = 0
            pbIntelligence.progress = 0
            pbPower.progress = 0
            pbSpeed.progress = 0
            pbStrength.progress = 0

            val stats = listOf(
                hero.powerstats?.combat,
                hero.powerstats?.durability,
                hero.powerstats?.intelligence,
                hero.powerstats?.power ,
                hero.powerstats?.speed,
                hero.powerstats?.strength,
            )

            CoroutineScope(Dispatchers.Main).launch {
                for (i in 0..100)
                {
                    delay(5)
                    if(stats[0]!! >= i)
                        pbCombat.progress = i
                    if(stats[1]!! >= i)
                        pbDurability.progress = i
                    if(stats[2]!! >= i)
                        pbIntelligence.progress = i
                    if(stats[3]!! >= i)
                        pbPower.progress = i
                    if(stats[4]!! >= i)
                        pbSpeed.progress = i
                    if(stats[5]!! >= i)
                        pbStrength.progress = i
                }

            }



//            pbDurability.progress = hero.powerstats?.durability ?: 0
//            pbIntelligence.progress = hero.powerstats?.intelligence ?: 0
//            pbPower.progress = hero.powerstats?.power ?: 0
//            pbSpeed.progress = hero.powerstats?.speed ?: 0
//            pbStrength.progress = hero.powerstats?.strength ?: 0

            "${hero.powerstats?.combat}".also { numCombat.text = it }
            "${hero.powerstats?.durability}".also { numDurability.text = it }
            "${hero.powerstats?.intelligence}".also { numIntelligence.text = it }
            "${hero.powerstats?.power}".also { numPower.text = it }
            "${hero.powerstats?.speed}".also { numSpeed.text = it }
            "${hero.powerstats?.strength}".also { numStrength.text = it }

        }

        window.enterTransition = Fade()
    }


}