package shop.local.customerui

import shop.local.customerui.admin.ShopCustomerCallback
import shop.local.customerui.admin.ShopCustomerReader
import shop.local.models.Customer
import shop.local.models.Shop

open class MyRegisteredShops(val reader : ShopCustomerReader, val customer : Customer) {

    private val callbacks = mutableListOf<ShopCustomerCallback>()

    init {
        reader.registerForChangesForCustomer(customer) {
            change -> callbacks.forEach { it(change) }
        }
    }

    fun getAllRegisteredShops() : List<Shop> = reader.retrieveAllShopsForCustomer(customer)

    fun registerForChange(changeType: ShopCustomerCallback) {
        callbacks.add(changeType)
    }
}