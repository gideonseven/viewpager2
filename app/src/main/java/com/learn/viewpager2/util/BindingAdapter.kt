package com.learn.viewpager2.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by gideon on 8/17/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */
@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    with(view) {
        clipToPadding = false
        clipChildren = false
        adapter = baseAdapter
    }
}

/**
 * [RecyclerView] spacing binding adapter. Give spacing on each items equally distributed.
 */
@BindingAdapter(value = ["spacingSize", "spacingEdgeEnabled"], requireAll = true)
fun bindAdapter(view: RecyclerView, spacingSize: Float, spacingEdgeEnabled: Boolean) {
    with(view) {
        addItemDecoration(
            AdaptiveSpacingItemDecoration(spacingSize.toInt(), spacingEdgeEnabled)
        )
    }
}
