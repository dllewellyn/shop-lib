package shop.local

import shop.local.models.Shop

interface MyRegisteredShops {
    fun getAllRegisteredShops() : List<Shop>
}