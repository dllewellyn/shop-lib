package shop.local.admin

import shop.local.models.Customer
import shop.local.models.Shop

interface ShopCustomerReader {

    fun retrieveAllCustomersForShop(shop : Shop) : List<Customer>
}