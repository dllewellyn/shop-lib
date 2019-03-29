package shop.local.models

enum class AddOrRemove {
    ADD,
    REMOVE
}

data class Points(val date : Long, val points : Int, val addOrRemove: AddOrRemove = AddOrRemove.ADD)