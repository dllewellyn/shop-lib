package shop.local.customerui.admin

interface QrCodeGenerator {
    fun generateNewQrCode() : QrCode
}