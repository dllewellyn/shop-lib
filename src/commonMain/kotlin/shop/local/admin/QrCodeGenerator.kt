package shop.local.admin

interface QrCodeGenerator {
    fun generateNewQrCode() : QrCode
}