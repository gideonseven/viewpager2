package com.learn.viewpager2.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.learn.viewpager2.R
import com.learn.viewpager2.util.Constant
import kotlinx.parcelize.Parcelize


/**
 * Created by gideon on 8/16/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */
@Parcelize
data class PagerItem(
    @DrawableRes val imageResId: Int = R.drawable.ic_no_image,
    @StringRes val titleResId: Int = Constant.ZERO,
    @StringRes val actionTextId: Int = Constant.ZERO,
    val isHidden: Boolean = false
) : Parcelable