package shop.local.admin

import shop.local.models.Customer
import shop.local.models.Points
import shop.local.models.Shop

interface  CustomerPointsReader {

    fun pointsForCustomerShop(customer : Customer, shop : Shop) : List<Points>
}