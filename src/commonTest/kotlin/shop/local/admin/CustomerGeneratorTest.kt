package shop.local.admin

import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerGeneratorTest {

    @Test
    fun testCustomerGenerator() {

        val uid = "Abc"
        val qrCode = "QrCode"

        val uidGen = mockk<UidGenerator>()
        every { uidGen.newUid() }.returns(uid)

        val qrCodeGenerator = mockk<QrCodeGenerator>()
        every { qrCodeGenerator.generateNewQrCode() }.returns(qrCode)

        val generator = CustomerGenerator(uidGen, qrCodeGenerator)
            .generateUser()

        assertEquals(uid, generator.id)
        assertEquals(qrCode, generator.qrCode)
    }
}