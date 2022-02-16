package com.example.youtube2.Adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtube2.Moduls.Shorts
import com.example.youtube2.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class ShortsAdapter(var context: Context,var shorts: ArrayList<Shorts>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return shorts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shorts,parent,false)
        return ShortsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val short = shorts[position]

        if (holder is ShortsViewHolder){

            Glide.with(context).load(short)

            var iv_shorts = holder.iv_shorts

            iv_shorts.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(short.iv_shorts,0f)
                }
            })
        }
    }

    class ShortsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var iv_shorts : YouTubePlayerView

        init {
            iv_shorts = view.findViewById(R.id.iv_shorts)
        }
    }
}