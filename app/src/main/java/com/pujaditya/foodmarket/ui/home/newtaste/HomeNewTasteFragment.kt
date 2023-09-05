package com.pujaditya.foodmarket.ui.home.newtaste

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
import com.pujaditya.foodmarket.databinding.FragmentHomeBinding
import com.pujaditya.foodmarket.databinding.FragmentHomeNewTasteBinding
import com.pujaditya.foodmarket.model.dummy.HomeModel
import com.pujaditya.foodmarket.model.dummy.HomeVerticalModel
import com.pujaditya.foodmarket.ui.detail.DetailActivity
import com.pujaditya.foodmarket.ui.home.HomeAdapter
import com.pujaditya.foodmarket.ui.home.SectionPagerAdapter

class HomeNewTasteFragment : Fragment(),HomeNewTasteAdapter.ItemAdapterCallback  {

    private var foodList: ArrayList<HomeVerticalModel> = ArrayList()
    private lateinit var binding: FragmentHomeNewTasteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeNewTasteBinding.inflate(inflater, container, false)
        return binding.root

          }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initDataDummy()
        var adapter= HomeNewTasteAdapter(foodList,this)
        var layoutManager: RecyclerView.LayoutManager=
            LinearLayoutManager(activity)
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
        Toast.makeText(context,"Ini toast"+data.title,Toast.LENGTH_LONG).show()
    }
}