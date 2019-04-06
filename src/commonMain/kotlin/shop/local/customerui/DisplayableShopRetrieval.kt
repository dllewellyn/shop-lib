package shop.local.customerui

import shop.local.models.Shop
import shop.local.models.ShopLocation

abstract class DisplayableShopRetrieval(private val shop : Shop, private val shopLocation : ShopLocation) {

    fun generateDisplayableShop() : DisplayableShop {
        return DisplayableShop(shop.name, retrieveImage(), shopLocation)
    }

    abstract fun retrieveImage() : ByteArray
}