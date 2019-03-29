package shop.local.utils

import shop.local.models.Points

fun Iterable<Points>.totalPoints() : Int {
    return map { it.points }.sum()
}