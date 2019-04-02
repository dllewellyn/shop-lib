package shop.local

import shop.local.utils.Changes
import shop.local.utils.compare
import kotlin.test.Test
import kotlin.test.assertEquals

class TestChanges {

    @Test
    fun `test that when you compare a map that is identical you get a dull response`() {
        val a = mapOf<String, String>()
        val b = mapOf<String, String>()

        assertEquals(Changes(), compare(a, b))
    }
}