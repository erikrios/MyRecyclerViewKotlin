package com.erikriosetiawan.myrecyclerviewkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_row_hero, p0, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(p0: ListViewHolder, p1: Int) {
        val (name, from, photo) = listHero[p1]

        Glide.with(p0.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(p0.imgPhoto)

        p0.tvName.text = name
        p0.tvFrom.text = from

        p0.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[p0.adapterPosition]) }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}