package shop.local.customerui

import shop.local.customerui.admin.ShopCustomerCallback

open class RetrieveListScreen(val pointsReader : MyPoints, val registeredShop: MyRegisteredShops, val displayableShopGenerator: DisplayableShopGenerator) {

    private val changeReceivers = mutableListOf<ShopCustomerCallback>()

    init {
        registeredShop.registerForChange {
            change ->
                changeReceivers.forEach {
                    it(change)
                }
        }
    }

    fun registerForShopChanges(changeCallback: ShopCustomerCallback) {
        changeReceivers.add(changeCallback)
    }

    fun retrieveRegisteredShops() : List<RegisteredShop> =
            registeredShop.getAllRegisteredShops()
                .map { RegisteredShop(it, pointsReader.getMyPointsForShop(it))}

    fun retrieveDisplayableShops() : List<DisplayableShop> =
            retrieveRegisteredShops().map { displayableShopGenerator.generateDisplayableShop(it.shop) }
}