package com.erikriosetiawan.myrecyclerviewkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(val listHeroes: ArrayList<Hero>): RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GridViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_grid_hero, p0, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    override fun onBindViewHolder(p0: GridViewHolder, p1: Int) {
        Glide.with(p0.itemView.context)
            .load(listHeroes[p1].photo)
            .apply(RequestOptions.overrideOf(350, 350))
            .into(p0.imgPhoto)

        p0.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHeroes[p0.adapterPosition]) }
    }

    inner class GridViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }

}