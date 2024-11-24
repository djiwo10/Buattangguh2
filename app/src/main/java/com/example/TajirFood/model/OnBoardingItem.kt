package com.example.TajirFood.model

import com.example.TajirFood.R

data class OnBoardingItem(
    val imageRes: Int,
    val textRes: Int,
    val titleRes: Int
)

val onBoardingItemList = listOf(
    OnBoardingItem(
        imageRes = R.drawable.food_1,
        textRes = R.string.onboard_text_1,
        titleRes = R.string.onboard_title_1
    ),
    OnBoardingItem(
        imageRes = R.drawable.delivery,
        textRes = R.string.onboard_text_2,
        titleRes = R.string.onboard_title_2
    ),
    OnBoardingItem(
        imageRes = R.drawable.food_2,
        textRes = R.string.onboard_text_3,
        titleRes = R.string.onboard_title_3
    ),
)