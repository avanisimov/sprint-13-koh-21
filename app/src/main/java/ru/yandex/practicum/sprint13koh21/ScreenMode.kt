package ru.yandex.practicum.sprint13koh21

import androidx.annotation.StringRes

enum class ScreenMode {
    CATALOG, CART
}


val ScreenMode.stringResId: Int
    @StringRes
    get() = when (this) {
        ScreenMode.CATALOG -> R.string.catalog_title
        ScreenMode.CART -> R.string.cart_title
    }