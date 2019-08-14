package com.erikriosetiawan.myrecyclerviewkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class CardViewHeroAdapter(private val listHeroes: ArrayList<Hero>) :
    RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardViewViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_cardview_hero, p0, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    override fun onBindViewHolder(p0: CardViewViewHolder, p1: Int) {
        val (name, from, photo) = listHeroes[p1]

        Glide.with(p0.itemView.context)
            .load(photo)
            .into(p0.imgPhoto)

        p0.tvName.text = name
        p0.tvFrom.text = from

        p0.btnFavorite.setOnClickListener { Toast.makeText(p0.itemView.context, "Favorite " + listHeroes[p0.adapterPosition].name, Toast.LENGTH_SHORT).show() }

        p0.btnShare.setOnClickListener { Toast.makeText(p0.itemView.context, "Share " + listHeroes[p0.adapterPosition].name, Toast.LENGTH_SHORT).show() }

        p0.itemView.setOnClickListener { Toast.makeText(p0.itemView.context, "Kamu memilih " + listHeroes[p0.adapterPosition].name, Toast.LENGTH_SHORT).show() }
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }

}