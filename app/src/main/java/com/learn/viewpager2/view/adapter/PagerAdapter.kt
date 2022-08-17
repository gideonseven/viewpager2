package com.learn.viewpager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learn.viewpager2.R
import com.learn.viewpager2.data.PagerItem
import com.learn.viewpager2.databinding.ItemPagerBinding
import com.learn.viewpager2.util.Constant


/**
 * Created by gideon on 8/16/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */
class PagerAdapter(
    val onClick: (PagerItem) -> Unit
) : RecyclerView.Adapter<PagerAdapter.ItemViewHolder>() {

    private var listDirect: List<PagerItem> = listOf()
    private var listOther: List<PagerItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemBinding: ItemPagerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_pager, parent, false
        )
        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (position == Constant.ZERO) holder.bind(listDirect)
        else holder.bind(listOther)
    }

    override fun getItemCount() = Constant.TWO

    inner class ItemViewHolder(private val binding: ItemPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: List<PagerItem>) {
            binding.pos = bindingAdapterPosition
            binding.adapter = ContentAdapter(data, onClick)
        }
    }

    fun updateData(newListDirect: List<PagerItem>, newListOther: List<PagerItem>) {
        listDirect = newListDirect
        listOther = newListOther
    }
}