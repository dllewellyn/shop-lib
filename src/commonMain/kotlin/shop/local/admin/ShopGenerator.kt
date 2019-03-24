package shop.local.admin

import shop.local.models.Shop

interface ShopGenerator {

    fun generateShop() : Shop
}