package shop.local.customerui

import shop.local.models.Shop

interface ShopGenerator {
    fun generateShop(name : String) : Shop
}