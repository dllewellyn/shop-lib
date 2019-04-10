package shop.local.common

sealed class ChangeType<T>(newList : List<T>) {
    data class Updated<T>(val updated: T, val newList : List<T>) : ChangeType<T>(newList)
    data class Removed<T>(val removed: T, val newList: List<T>) : ChangeType<T>(newList)
    data class Added<T>(val added: T, val newList: List<T>) : ChangeType<T>(newList)

}