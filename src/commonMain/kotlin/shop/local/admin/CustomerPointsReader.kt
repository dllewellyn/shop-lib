package shop.local.customerui.admin

import shop.local.customerui.ChangePointsCallback
import shop.local.models.Customer
import shop.local.models.Points
import shop.local.models.Shop

interface  CustomerPointsReader {

    fun pointsForCustomerShop(customer : Customer, shop : Shop) : List<Points>
    fun registerForChange(customer : Customer, callback : ChangePointsCallback)
}