package shop.local.customerui

import shop.local.models.Shop

interface DisplayableShopGenerator {
    fun generateDisplayableShop(shop : Shop) : DisplayableShop
}