package shop.local.admin

import shop.local.models.Customer


class CustomerGenerator(val uid : UidGenerator, val qrCodeGenerator: QrCodeGenerator) {
    fun generateUser() : Customer {
        val qrCode = qrCodeGenerator.generateNewQrCode()
        val uid = uid.newUid()
        return Customer(uid, qrCode)
    }
}