package shop.local.admin

import shop.local.models.Customer


class CustomerGenerator(val uid : UidGenerator, val qrCodeGenerator: QrCodeGenerator) {
    fun generateUser() = Customer(uid.newUid(), qrCodeGenerator.generateNewQrCode())
}