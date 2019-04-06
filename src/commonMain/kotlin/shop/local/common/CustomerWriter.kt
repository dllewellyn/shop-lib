package shop.local.customerui.common

import shop.local.models.Customer

interface CustomerWriter {
    fun newCustomer(customer : Customer)
}