package com.pujaditya.foodmarket.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pujaditya.foodmarket.databinding.FragmentHomeBinding
import com.pujaditya.foodmarket.model.dummy.HomeModel

class HomeFragment : Fragment(),HomeAdapter.ItemAdapterCallback {
    private var foodList: ArrayList<HomeModel> = ArrayList()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initDataDummy()
        var adapter=HomeAdapter(foodList,this)
        var layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvData.layoutManager=layoutManager
        binding.rvData.adapter=adapter

        val sectionPagerAdapter=SectionPagerAdapter(childFragmentManager)
        binding.viewPager.adapter=sectionPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    fun initDataDummy() {
        foodList = ArrayList()
        foodList.add(HomeModel("Cherry Healthy", "", 5f))
        foodList.add(HomeModel("Burger Tempeh", "", 4.5f))
        foodList.add(HomeModel("Kasreng Rice", "", 5f))
    }

    override fun onClick(v: View, data: HomeModel) {
        TODO("Not yet implemented")
    }
}