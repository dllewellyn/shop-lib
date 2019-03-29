package shop.local

import shop.local.admin.*
import shop.local.models.Customer
import shop.local.models.CustomerPoints
import shop.local.models.Points
import shop.local.models.Shop
import shop.local.utils.totalPoints

class CustomerShopListWriter : ShopCustomerReader, ShopCustomerWriter, CustomerPointsWriter, CustomerPointsReader {

    private val linker = mutableMapOf<Shop, MutableList<CustomerPoints>>()

    override fun pointsForCustomerShop(customer: Customer, shop: Shop) :  List<Points> {
        return linker[shop]?.first { it.customer == customer}?.points ?: listOf()
    }

    override fun addPoints(customer: Customer, shop: Shop, points: Points) {
        linker[shop]?.first { customerPoints -> customerPoints.customer == customer }?.points?.add(points)
    }

    override fun retrieveAllCustomersForShop(shop: Shop): List<Customer> {
        return linker[shop]?.map { it.customer } ?: listOf()
    }

    override fun writeCustomerForShop(shop: Shop, customer: Customer) {
        if (linker.containsKey(shop)) {
            linker[shop]?.add(CustomerPoints(customer, mutableListOf()))
        } else {
            linker[shop] = mutableListOf(CustomerPoints(customer, mutableListOf()))
        }
    }

}

fun main(args : Array<String>) {

    val generator = object : ShopGenerator {
        override fun generateShop(name: String) = Shop(name)
    }

    val customerGenerator =  CustomerGenerator(
        uid = object  : UidGenerator {
            override fun newUid() = "UIDA"
        },
        qrCodeGenerator = object : QrCodeGenerator {
            override fun generateNewQrCode(): String = "QrCode"
        })


    val shop = generator.generateShop("Test shop")
    val customer = customerGenerator.generateUser()

    val customerShopList = CustomerShopListWriter()
    customerShopList.writeCustomerForShop(shop, customer)
    customerShopList.addPoints(customer, shop, Points(0, 1))
    customerShopList.addPoints(customer, shop, Points(0, 2))

    println(customerShopList.pointsForCustomerShop(customer, shop).totalPoints())

}