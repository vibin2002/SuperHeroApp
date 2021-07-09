package com.killerinstinct.superheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.killerinstinct.superheroapp.adapters.HeroAdapter
import com.killerinstinct.superheroapp.data.HeroResponse
import com.killerinstinct.superheroapp.databinding.ActivityMainBinding
import com.killerinstinct.superheroapp.databinding.HeroCardBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(),HeroAdapter.OnHeroItemClickListener {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = listOf<HeroResponse>()


//        lifecycleScope.launchWhenStarted {
//            list = viewModel._herolist.value!!
//            Log.d(
//                "DoctorStrange",
//                list.toString()
//            )
//        }

        viewModel._herolist.observe(this, Observer {
            list = it
            Log.d("DoctorStrange", list.toString())
            list.forEach {
                println("booyah ${it.id} ${it.name}" )
            }
            if(list.isEmpty())
            {
                findViewById<ProgressBar>(R.id.progress_bar).visibility = ProgressBar.VISIBLE
            }
            else
            {

                findViewById<ProgressBar>(R.id.progress_bar).visibility = ProgressBar.INVISIBLE
                setupRecyclerView(list)
            }
        })
        setupRecyclerView(list)
    }

    private fun setupRecyclerView(list: List<HeroResponse>)
    {
        binding.heroRecyclerView.layoutManager = GridLayoutManager(this,2)
        binding.heroRecyclerView.adapter = HeroAdapter(list,this)
    }

    override fun onClick(position: Int, heroResponse: HeroResponse,binding: HeroCardBinding) {
        val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
                binding.heroImage,
            "imageTrans"
        )
        Intent(this, StatsActivity::class.java).apply {
            putExtra("Hero", heroResponse)
            startActivity(this,activityOptionsCompat.toBundle())
        }
    }

}