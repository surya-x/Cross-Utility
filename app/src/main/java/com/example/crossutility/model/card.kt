package com.example.crossutility.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class card(
    @StringRes val titleResourceID: Int,
    @StringRes val descResourceID: Int,
    @DrawableRes val iconResourceID: Int
) {}