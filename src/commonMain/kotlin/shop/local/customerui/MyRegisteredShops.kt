package shop.local.customerui

import shop.local.models.Shop

interface MyRegisteredShops {
    fun getAllRegisteredShops() : List<Shop>
}