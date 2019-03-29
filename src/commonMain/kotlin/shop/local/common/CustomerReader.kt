package shop.local.common

import shop.local.admin.QrCode
import shop.local.models.Customer

interface CustomerReader {
    fun allCustomers() : List<Customer>
    fun customerForQrCode(qrCode: QrCode) : Customer
}