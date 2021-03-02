package com.example.crossutility.data

import com.example.crossutility.R
import com.example.crossutility.model.card

class datasource {
    fun loadCards(): List<card> {
        return listOf<card>(
            card(R.string.title1, R.string.desc1, R.drawable.icon1),
            card(R.string.title2, R.string.desc2, R.drawable.icon2),
            card(R.string.title3, R.string.desc3, R.drawable.icon3),
            card(R.string.title4, R.string.desc4, R.drawable.icon4),
            card(R.string.title5, R.string.desc5, R.drawable.icon5)
        )
    }
}