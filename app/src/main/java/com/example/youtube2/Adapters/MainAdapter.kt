package com.example.youtube2.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtube2.Moduls.Main
import com.example.youtube2.Moduls.Shorts
import com.example.youtube2.R
import com.google.android.material.imageview.ShapeableImageView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class MainAdapter(var context: Context, var items: ArrayList<Main>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var TYPE_MAIN = 0
    var TYPE_SHORTS = 1

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        if (items.get(position).getSubShorts() != null){
            return TYPE_SHORTS
        }
        return TYPE_MAIN
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_SHORTS){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shorts_recycler,parent,false)
            return ShortsViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_recycler,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val videoItem = items[position]

        if (holder is MainViewHolder){
            var iv_mainProfile = holder.iv_mainProfile
            iv_mainProfile.setImageResource(videoItem.iv_mainProfile)

            Glide.with(context).load(videoItem.iv_video).into(holder.iv_mainProfile)

            var iv_video = holder.iv_video

            iv_video.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(videoItem.iv_video,0f)
                }
            })
        }

        if (holder is ShortsViewHolder){
            var recyclerView = holder.recyclerView

            recyclerView.setLayoutManager(LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false))
            val subShorts: ArrayList<Shorts>? = videoItem.getSubShorts()
            refreshSubAdapter(recyclerView,subShorts as ArrayList<Shorts>)
        }
    }

    fun refreshSubAdapter(recyclerShorts: RecyclerView,items: ArrayList<Shorts>){
        val adapter = ShortsAdapter(context,items)
        recyclerShorts.adapter = adapter
    }

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var iv_video: YouTubePlayerView
        var iv_mainProfile: ShapeableImageView

        init {
            iv_video = view.findViewById(R.id.iv_video)
            iv_mainProfile = view.findViewById(R.id.iv_mainProfile)
        }
    }

    class ShortsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerShorts)
        }
    }
}