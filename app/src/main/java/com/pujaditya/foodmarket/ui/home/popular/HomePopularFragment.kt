package com.pujaditya.foodmarket.ui.home.popular

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pujaditya.foodmarket.R
import com.pujaditya.foodmarket.databinding.FragmentHomeNewTasteBinding
import com.pujaditya.foodmarket.databinding.FragmentHomePopularBinding
import com.pujaditya.foodmarket.model.dummy.HomeVerticalModel
import com.pujaditya.foodmarket.ui.detail.DetailActivity
import com.pujaditya.foodmarket.ui.home.newtaste.HomeNewTasteAdapter

class HomePopularFragment : Fragment(),HomeNewTasteAdapter.ItemAdapterCallback  {
    private var foodList: ArrayList<HomeVerticalModel> = ArrayList()
    private lateinit var binding: FragmentHomePopularBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomePopularBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    initDataDummy()
        var adapter= HomeNewTasteAdapter(foodList,this)
        var layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(activity)
        binding.rvData.layoutManager=layoutManager
        binding.rvData.adapter=adapter
    }

    fun initDataDummy() {
        foodList = ArrayList()
        foodList.add(HomeVerticalModel("Cherry Healthy","10000","", 5f))
        foodList.add(HomeVerticalModel("Burger Tempeh", "20000","", 4.5f))
        foodList.add(HomeVerticalModel("Kasreng Rice", "30000","" ,5f))
    }

    override fun onClick(v: View, data: HomeVerticalModel) {
        val detail= Intent(activity, DetailActivity::class.java)
        startActivity(detail)
        Toast.makeText(context,"Ini toast"+data.title, Toast.LENGTH_LONG).show()
    }
    }
