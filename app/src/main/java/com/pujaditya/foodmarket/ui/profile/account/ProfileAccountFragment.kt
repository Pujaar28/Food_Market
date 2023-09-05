package com.pujaditya.foodmarket.ui.profile.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pujaditya.foodmarket.R
import com.pujaditya.foodmarket.databinding.FragmentProfileAccountBinding
import com.pujaditya.foodmarket.databinding.FragmentProfileBinding
import com.pujaditya.foodmarket.model.dummy.ProfileMenuModel
import com.pujaditya.foodmarket.ui.profile.ProfileMenuAdapter

class ProfileAccountFragment :Fragment(),ProfileMenuAdapter.ItemAdapterCallback{
    private lateinit var binding:FragmentProfileAccountBinding
    private var menuArrayList:ArrayList<ProfileMenuModel> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProfileAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initDataDummy()

        var adapter=ProfileMenuAdapter(menuArrayList,this)
        var layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(activity)
        binding.apply {
            rvData.layoutManager=layoutManager
            rvData.adapter=adapter
        }
    }
    fun initDataDummy(){
        menuArrayList= ArrayList()
        menuArrayList.add(ProfileMenuModel("Edit Profile"))
        menuArrayList.add(ProfileMenuModel("Home Address"))
        menuArrayList.add(ProfileMenuModel("Security"))
        menuArrayList.add(ProfileMenuModel("Payments"))
    }

    override fun onClick(v: View, data: ProfileMenuModel) {
        Toast.makeText(context,"ini menu yang anda click "+data.title,Toast.LENGTH_LONG).show()
    }

}