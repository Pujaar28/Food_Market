package com.pujaditya.foodmarket.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.pujaditya.foodmarket.ui.home.newtaste.HomeNewTasteFragment
import com.pujaditya.foodmarket.ui.home.popular.HomePopularFragment
import com.pujaditya.foodmarket.ui.home.recommended.HomeRecommendedFragment
import com.pujaditya.foodmarket.ui.profile.account.ProfileAccountFragment
import com.pujaditya.foodmarket.ui.profile.foodmarket.ProfileFoodMarketFragment

class ProfileSectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Account"
            1 -> "Food Market"
            else ->""
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment
        return when (position) {
            0 -> {
                fragment = ProfileAccountFragment()
                return fragment
            }

            1 -> {
                fragment = ProfileFoodMarketFragment()
                return fragment
            }

            else -> {
                fragment = ProfileAccountFragment()
                return fragment
            }
        }
    }
}