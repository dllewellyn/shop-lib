package shop.local.customerui

import shop.local.common.ChangeType
import shop.local.customerui.admin.CustomerPointsReader
import shop.local.models.Customer
import shop.local.models.Shop
import shop.local.models.ShopPoints

typealias ChangePointsCallback = (ChangeType<ShopPoints>) -> Unit

open class MyPoints(val pointsReader: CustomerPointsReader, val customer : Customer) {

    private val callbackList = mutableListOf<ChangePointsCallback>()

    init {
        pointsReader.registerForChange(customer) {
            change -> callbackList.forEach { it(change) }
        }
    }

    fun getMyPointsForShop(shop : Shop) = pointsReader.pointsForCustomerShop(customer, shop)

    fun registerForUpdates(changeCallback : ChangePointsCallback) {
        callbackList.add(changeCallback)
    }
}