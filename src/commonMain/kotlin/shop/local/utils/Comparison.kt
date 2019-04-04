package shop.local.utils

// Some functions to reflect the changes to update a UI.
// Added to new - when there are values in the keys list that have been added to the target list
// Removed in new - when there are values in the existing keys, that are not in the new keys
// Updated VALUES in the new list
data class Changes(val addedToNew : List<Int> = listOf(), val removedInNew : List<Int> = listOf(), val updatedInNew : List<Int> = listOf())

fun <T,E>compare(initial : Map<T, E>, new : Map<T, E>) : Changes {

    val addedToNew = mutableListOf<Int>()
    val removedInNew = mutableListOf<Int>()
    val updatedInNew = mutableListOf<Int>()

    initial.keys.forEachIndexed {
        index, t ->
            if (!new.containsKey(t)) {
                removedInNew.add(index)
            }
    }

    new.keys.forEachIndexed {
            index, t ->
        if (!initial.containsKey(t)) {
            addedToNew.add(index)
        }
    }

    new.keys.forEachIndexed {
        index, t ->
        if (initial.containsKey(t)) {
            if (initial[t] != new[t]) {
                updatedInNew.add(index)
            }
        }
    }


    return Changes(addedToNew, removedInNew, updatedInNew)
}