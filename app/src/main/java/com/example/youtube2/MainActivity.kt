package com.example.youtube2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube2.Adapters.ExploreAdapter
import com.example.youtube2.Adapters.MainAdapter
import com.example.youtube2.Adapters.ShortsAdapter
import com.example.youtube2.Moduls.Explore
import com.example.youtube2.Moduls.Main
import com.example.youtube2.Moduls.Shorts
import kotlin.math.exp

class MainActivity : AppCompatActivity() {

    lateinit var recyclerExplore : RecyclerView
    lateinit var recyclerMain : RecyclerView
    lateinit var recyclerShorts : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

   fun initViews(){

       recyclerExplore = findViewById(R.id.recyclerExplore)
       recyclerExplore.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))
       recyclerMain = findViewById(R.id.recyclerviewMain)
       recyclerMain.setLayoutManager(GridLayoutManager(this,1))

       refreshExplore(getAllExplores())
       refreshMain(getAllMains())

   }
    fun refreshExplore(explore: ArrayList<Explore>){
        val adapter = ExploreAdapter(this,explore)
        recyclerExplore.adapter = adapter
    }
    fun refreshMain(main: ArrayList<Main>){
        val adapter = MainAdapter(this,main)
        recyclerMain.adapter = adapter
    }


    fun getAllExplores() : ArrayList<Explore>{
        val explore : ArrayList<Explore> = ArrayList()

        explore.add(Explore(null,"All"))
        explore.add(Explore(null,"Music"))
        explore.add(Explore(null,"Mixes"))
        explore.add(Explore(null,"Superhero movies"))
        explore.add(Explore(null,"Comedies"))
        explore.add(Explore(null,"Thrillers"))
        explore.add(Explore(null,"The Flash"))
        explore.add(Explore(null,"Computer Science"))

        return explore
    }
    fun getAllMains() : ArrayList<Main>{
        val main: ArrayList<Main> = ArrayList()

        main.add(Main("j6PbonHsqW0",R.drawable.im_me,null))
        main.add(Main("H9154xIoYTA",R.drawable.im_me,getAllShorts()))
        main.add(Main("W64yrqCehuc",R.drawable.im_me,null))
        main.add(Main("668nUCeBHyY",R.drawable.im_me,null))
        main.add(Main("EgBJmlPo8Xw",R.drawable.im_me,null))
        main.add(Main("EMvbzRThZvU",R.drawable.im_me,null))
        main.add(Main("zON0wDD7VJY",R.drawable.im_me,null))
        main.add(Main("8yYlecVw9oo",R.drawable.im_me,null))
        main.add(Main("9wuVuljRkSg",R.drawable.im_me,null))
        main.add(Main("Imo2ZbGIdb0",R.drawable.im_me,null))

        return main
    }
    fun getAllShorts() : ArrayList<Shorts>{

        val short: ArrayList<Shorts> = ArrayList()

       short.add(Shorts("4s0TCiuuCUE"))
        short.add(Shorts("vqLoGp1u76w"))
        short.add(Shorts("iGut_MVMcUY"))
        short.add(Shorts("LBKuHpJprVI"))
        short.add(Shorts("tD_-d87uO7k"))
        short.add(Shorts("gBRi6aZJGj4"))
        short.add(Shorts("5R6BYT176Bk"))
        short.add(Shorts("2Vv-BfVoq4g"))
        short.add(Shorts("GmrnG1FjvPA"))
        short.add(Shorts("GmrnG1FjvPA"))


        return short
    }
}