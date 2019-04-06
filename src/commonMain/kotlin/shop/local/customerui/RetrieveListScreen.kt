package shop.local.customerui

abstract class RetrieveListScreen(val pointsReader : MyPoints, val registeredShop: MyRegisteredShops, val displayableShopGenerator: DisplayableShopGenerator) {

    fun retrieveRegisteredShops() : List<RegisteredShop> =
            registeredShop.getAllRegisteredShops()
                .map { RegisteredShop(it, pointsReader.getMyPointsForShop(it))}

    fun retrieveDisplayableShops() : List<DisplayableShop> =
            retrieveRegisteredShops().map { displayableShopGenerator.generateDisplayableShop(it.shop) }
}