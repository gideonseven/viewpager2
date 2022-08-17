package com.learn.viewpager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learn.viewpager2.R
import com.learn.viewpager2.data.PagerItem
import com.learn.viewpager2.databinding.ItemContentBinding


/**
 * Created by gideon on 8/16/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */
class ContentAdapter constructor(
    private val data: List<PagerItem>,
    val onClick: (PagerItem) -> Unit
) : RecyclerView.Adapter<ContentAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemContent: ItemContentBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_content, parent, false
        )
        return ItemViewHolder(itemContent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ItemViewHolder(
        private val binding: ItemContentBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PagerItem) {
            with(binding) {
                this.item = item
                hideLine = bindingAdapterPosition == data.size - 1
                clContainer.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }
}