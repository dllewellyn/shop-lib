package shop.local.models

import shop.local.admin.QrCode

data class Customer(val id : String, val qrCode : QrCode)