package shop.local

import shop.local.utils.Changes
import shop.local.utils.compare
import kotlin.test.Test
import kotlin.test.assertEquals

class TestChanges {

    @Test
    fun testThatYouGetABlankResponseWithNoChanges() {
        val a = mapOf<String, String>()
        val b = mapOf<String, String>()

        assertEquals(Changes(), compare(a, b))
    }

    @Test
    fun testThatYouCanCompareTwoMapsWithANewKey() {
        val a = mutableMapOf<String, String>().apply {
            put("A", "A")
        }

        val b = mutableMapOf<String, String>().apply {
            put("A", "A")
            put("B", "B")
        }

        assertEquals(Changes(listOf(1)), compare(a, b))
    }

    @Test
    fun testThatYouCanCompareTwoMapsWithRemovedKey() {
        val a = mutableMapOf<String, String>().apply {
            put("A", "A")
            put("B", "B")
        }

        val b = mutableMapOf<String, String>().apply {
            put("A", "A")
        }

        assertEquals(Changes(removedInNew = listOf(1)), compare(a, b))
    }

    @Test
    fun testThatYouCanCompareTwoMapsWithAChangedValue() {
        val a = mutableMapOf<String, String>().apply {
            put("A", "A")
            put("B", "B")
        }

        val b = mutableMapOf<String, String>().apply {
            put("A", "A")
            put("B", "C")
        }

        assertEquals(Changes(updatedInNew = listOf(1)), compare(a, b))
    }


    @Test
    fun testThatMultipleKeysInRandomOrderWorks() {
        val a = mutableMapOf<String, String>().apply {
            put("A", "A")
            put("B", "B")
            put("D", "A")

        }

        val b = mutableMapOf<String, String>().apply {
            put("A", "A")
            put("B", "A")
            put("C", "A")
            put("D", "A")

        }

        assertEquals(Changes(addedToNew = listOf(2), updatedInNew = listOf(1)), compare(a, b))
    }
}