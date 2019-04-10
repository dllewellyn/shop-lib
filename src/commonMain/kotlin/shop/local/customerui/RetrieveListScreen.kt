package shop.local.customerui

open class RetrieveListScreen(val pointsReader : MyPoints, val registeredShop: MyRegisteredShops, val displayableShopGenerator: DisplayableShopGenerator) {

    private val changeReceivers = mutableListOf<ChangeCallback>()

    init {
        registeredShop.registerForChange {
            change ->
                changeReceivers.forEach {
                    it(change)
                }
        }
    }

    fun registerForChange(changeCallback: ChangeCallback) {
        changeReceivers.add(changeCallback)
    }

    fun retrieveRegisteredShops() : List<RegisteredShop> =
            registeredShop.getAllRegisteredShops()
                .map { RegisteredShop(it, pointsReader.getMyPointsForShop(it))}

    fun retrieveDisplayableShops() : List<DisplayableShop> =
            retrieveRegisteredShops().map { displayableShopGenerator.generateDisplayableShop(it.shop) }
}