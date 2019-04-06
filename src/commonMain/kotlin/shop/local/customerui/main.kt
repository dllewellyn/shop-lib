//package shop.local.customerui
//
//import shop.local.admin.*
//import shop.local.models.Customer
//import shop.local.models.CustomerPoints
//import shop.local.models.Points
//import shop.local.models.Shop
//import shop.local.utils.totalPoints
//import shop.local.common.*
//import shop.local.customerui.admin.*
//import shop.local.customerui.common.CustomerReader
//import shop.local.customerui.common.CustomerWriter
//
//class CustomerShopListWriter : CustomerWriter, CustomerReader,
//    ShopCustomerReader, ShopCustomerWriter,
//    CustomerPointsWriter, CustomerPointsReader {
//
//
//    private val linker = mutableMapOf<Shop, MutableList<CustomerPoints>>()
//    private val allCustomerList = mutableListOf<Customer>()
//
//    override fun pointsForCustomerShop(customer: Customer, shop: Shop) :  List<Points> {
//        return linker[shop]?.first { it.customer == customer}?.points ?: listOf()
//    }
//
//    override fun addPoints(customer: Customer, shop: Shop, points: Points) {
//        linker[shop]?.first { customerPoints -> customerPoints.customer == customer }?.points?.add(points)
//    }
//
//    override fun retrieveAllCustomersForShop(shop: Shop): List<Customer> {
//        return linker[shop]?.map { it.customer } ?: listOf()
//    }
//
//    override fun writeCustomerForShop(shop: Shop, customer: Customer) {
//        if (linker.containsKey(shop)) {
//            linker[shop]?.add(CustomerPoints(customer, mutableListOf()))
//        } else {
//            linker[shop] = mutableListOf(CustomerPoints(customer, mutableListOf()))
//        }
//    }
//
//    override fun allCustomers() = allCustomerList
//
//    override fun customerForQrCode(qrCode: QrCode) =  allCustomerList.first {
//        customer -> customer.qrCode == qrCode
//    }
//
//    override fun newCustomer(customer: Customer) {
//        allCustomerList.add(customer)
//    }
//
//}
//
//class Qr(val q : String) : QrCode {
//    override fun get() = q
//
//    override fun equals(other: Any?): Boolean {
//        return if (other is Qr) {
//            other.q == q
//        } else {
//            false
//        }
//    }
//}
//
//fun main(args : Array<String>) {
//
//    val generator = object : ShopGenerator {
//        override fun generateShop(name: String) = Shop(name)
//    }
//
//    val customerGenerator = CustomerGenerator(
//        uid = object : UidGenerator {
//            override fun newUid(): String {
//                return "UIDA"
//            }
//        },
//        qrCodeGenerator = object : QrCodeGenerator {
//            override fun generateNewQrCode(): QrCode {
//                return Qr("abc")
//            }
//        })
//
//
//    val shop = generator.generateShop("Test shop")
//    val customer = customerGenerator.generateUser()
//
//    val customerShopList = CustomerShopListWriter()
//    customerShopList.newCustomer(customer)
//    customerShopList.writeCustomerForShop(shop, customer)
//
//
//    val scanner = shop.local.customerui.common.Scanner(customerShopList, shop, customerShopList, customerShopList)
//    scanner.scanToAddPoints(customer.qrCode, Points(0, 1))
//    scanner.scanToAddPoints(customer.qrCode, Points(0, 2))
//
//    println(scanner.scanForPoints(customer.qrCode).totalPoints())
//
//}