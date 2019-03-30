package shop.local.customer

import shop.local.models.Points
import shop.local.models.Shop

interface CustomerController {

    fun retrieveShopsAndPoints() : Map<Shop, List<Points>>
}