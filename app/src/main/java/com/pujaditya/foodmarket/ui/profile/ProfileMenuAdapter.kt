package com.pujaditya.foodmarket.ui.profile

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
import com.pujaditya.foodmarket.model.dummy.ProfileMenuModel

class ProfileMenuAdapter(
    private val listData: List<ProfileMenuModel>,
    private val itemAdapterCallback: ItemAdapterCallback
) : RecyclerView.Adapter<ProfileMenuAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileMenuAdapter.ViewHolder {
       val layoutInflater=LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_menu_profile,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileMenuAdapter.ViewHolder, position: Int) {
      holder.bind(listData[position],itemAdapterCallback)
    }


    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(data:ProfileMenuModel, itemAdapterCallback: ItemAdapterCallback){
            itemView.apply {
                val tv_Title:TextView=findViewById(R.id.tv_editprofile)

                tv_Title.text=data.title
                itemView.setOnClickListener{
                    itemAdapterCallback.onClick(it,data)
                }
            }
        }

    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: ProfileMenuModel)
    }
}