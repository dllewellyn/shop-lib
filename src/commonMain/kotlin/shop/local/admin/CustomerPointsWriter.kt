package shop.local.admin

import shop.local.models.Customer
import shop.local.models.Points
import shop.local.models.Shop

interface CustomerPointsWriter {
    fun addPoints(customer : Customer, shop : Shop, points : Points)
}