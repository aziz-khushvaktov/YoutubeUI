package com.example.youtube2.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube2.Moduls.Explore
import com.example.youtube2.R

class ExploreAdapter(var context: Context, var items: ArrayList<Explore>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var TYPE_EXPLORE = 0
    var TYPE_NONE_EXPLORE = 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0){
            return TYPE_EXPLORE
        }
        return TYPE_NONE_EXPLORE
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_EXPLORE){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore,parent,false)
            return ExploreViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed,parent,false)
        return ExploreViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val explore = items[position]

        if (holder is ExploreViewHolder){
            var tv_explore = holder.tv_explore

            tv_explore?.text = explore.tv_explore
        }
    }

    class ExploreViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var tv_explore: TextView? = null

        init {
            tv_explore = view.findViewById(R.id.tv_explore)
        }
    }
}