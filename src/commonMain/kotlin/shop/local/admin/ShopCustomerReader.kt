package shop.local.customerui.admin

import shop.local.models.Customer
import shop.local.models.Shop

typealias ShopCustomerCallback = (Shop) -> Unit

interface ShopCustomerReader {

    fun retrieveAllCustomersForShop(shop : Shop) : List<Customer>
    fun retrieveAllShopsForCustomer(customer : Customer) : List<Shop>
    fun registerForChangesForCustomer(customer : Customer, callback: ShopCustomerCallback)
}