package shop.local.customerui.admin

import shop.local.models.Customer
import shop.local.models.Shop

interface ShopCustomerWriter {

    fun writeCustomerForShop(shop : Shop, customer : Customer)
}