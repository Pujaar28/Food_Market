package com.pujaditya.foodmarket.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedListAdapterCallback
import com.bumptech.glide.Glide
import com.pujaditya.foodmarket.R
import com.pujaditya.foodmarket.model.dummy.HomeModel

class HomeAdapter(
    private val listData: List<HomeModel>,
    private val itemAdapterCallback: ItemAdapterCallback
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
       val layoutInflater=LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_home_horizontal,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
      holder.bind(listData[position],itemAdapterCallback)
    }


    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(data:HomeModel, itemAdapterCallback: ItemAdapterCallback){
            itemView.apply {
                val tv_Title:TextView=findViewById(R.id.tvTitle)
                val iv_Poster:ImageView=findViewById(R.id.iv_Poster)
                val rb_Food:RatingBar=findViewById(R.id.rb_Food)

                tv_Title.text=data.title
                rb_Food.rating=data.rating

//                Glide.with(context)
//                    .load(data.src)
//                    .into(iv_Poster)

                itemView.setOnClickListener{
                    itemAdapterCallback.onClick(it,data)
                }
            }
        }

    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: HomeModel)
    }
}