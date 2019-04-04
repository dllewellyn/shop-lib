package shop.local

import shop.local.models.DisplayableShop
import shop.local.models.Shop

interface DisplayableShopGenerator {
    fun generateDisplayableShop(shop : Shop) : DisplayableShop
}