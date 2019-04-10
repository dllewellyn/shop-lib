package shop.local.customerui

import shop.local.common.ChangeType
import shop.local.models.Shop

typealias ChangeCallback = (ChangeType<Shop>) -> Unit

interface MyRegisteredShops {
    fun getAllRegisteredShops() : List<Shop>
    fun notifyChange()
    fun registerForChange(changeType: ChangeCallback)
}