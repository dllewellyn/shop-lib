package shop.local.customerui

import shop.local.customerui.admin.CustomerPointsReader
import shop.local.models.Customer
import shop.local.models.Shop


abstract class MyPoints(val pointsReader: CustomerPointsReader, val customer : Customer) {
    fun getMyPointsForShop(shop : Shop) = pointsReader.pointsForCustomerShop(customer, shop)
}