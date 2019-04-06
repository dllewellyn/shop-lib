package shop.local.customerui.admin

import shop.local.models.Shop

interface ShopGenerator {

    fun generateShop() : Shop
}