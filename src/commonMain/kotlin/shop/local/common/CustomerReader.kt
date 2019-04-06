package shop.local.customerui.common

import shop.local.customerui.admin.QrCode
import shop.local.models.Customer

interface CustomerReader {
    fun allCustomers() : List<Customer>
    fun customerForQrCode(qrCode: QrCode) : Customer
}