package shop.local.customerui

import shop.local.models.Points
import shop.local.models.Shop

data class RegisteredShop(val shop : Shop, val points : List<Points>)