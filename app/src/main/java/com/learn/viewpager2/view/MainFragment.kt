package com.learn.viewpager2.view

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.learn.viewpager2.R
import com.learn.viewpager2.data.PagerItem
import com.learn.viewpager2.databinding.FragmentMainBinding
import com.learn.viewpager2.view.adapter.PagerAdapter


/**
 * Created by gideon on 8/16/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */
class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    private val viewModel: MainViewModel by lazy { MainViewModel() }

    private var cardHeight = 0
    private var tabHeight = 0
    private var containerHeight = 0

    private val pagerAdapter: PagerAdapter by lazy {
        PagerAdapter(
            onClick = { cr ->
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        setupPagerAdapter()

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    activity?.finish()
                }
            }
        )
    }

    private fun setupPagerAdapter() {
        binding?.vpCr?.apply {
            val vp = this
            adapter = pagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)


                }
            })

            binding?.tabCr?.apply {
                //SetTitle
                val titles =
                    arrayOf(getString(R.string.tab_one), getString(R.string.tab_two))

                TabLayoutMediator(this, vp) { tab, position ->
                    tab.text = titles[position]
                }.attach()
            }

            pagerAdapter.updateData(
                newListDirect = listDirect(),
                newListOther = listInDirect()
            )
        }
    }

    private fun listDirect(): List<PagerItem> {
        val list = arrayListOf<PagerItem>()
        for(i in 0 until 3){
            list.add(PagerItem(actionTextId = R.string.item))
        }
        return list
    }

    private fun listInDirect(): List<PagerItem> {
        val list = arrayListOf<PagerItem>()
        for(i in 0 until 10){
            list.add(PagerItem(actionTextId = R.string.item))
        }
        return list
    }
}