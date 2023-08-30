package com.pujaditya.foodmarket.ui.home.newtaste

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
import com.pujaditya.foodmarket.model.dummy.HomeVerticalModel
import com.pujaditya.foodmarket.utils.Helpers.formatPrice

class HomeNewTasteAdapter(
    private val listData: List<HomeVerticalModel>,
    private val itemAdapterCallback: ItemAdapterCallback

) : RecyclerView.Adapter<HomeNewTasteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewTasteAdapter.ViewHolder {
       val layoutInflater=LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_home_vertical,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeNewTasteAdapter.ViewHolder, position: Int) {
      holder.bind(listData[position],itemAdapterCallback)
    }


    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(data:HomeVerticalModel, itemAdapterCallback: ItemAdapterCallback){
            itemView.apply {
//                var tv_Title:TextView=findViewById(R.id.tvTitle)
//                var tv_Price:TextView=findViewById(R.id.tvPrice)
//                var rb_Food:RatingBar=findViewById(R.id.rbFood)
//
//                tv_Title.text=data.title
//                tv_Price.formatPrice(data.price)
//                rb_Food.rating=data.rating
//
////                Glide.with(context)
////                    .load(data.src)
////                    .into(iv_Poster)

                itemView.setOnClickListener{
                    itemAdapterCallback.onClick(it,data)
                }
            }
        }

    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: HomeVerticalModel)
    }
}