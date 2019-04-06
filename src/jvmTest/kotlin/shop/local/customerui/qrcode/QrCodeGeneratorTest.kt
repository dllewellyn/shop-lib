package shop.local.customerui.qrcode

import org.junit.Test
import java.io.FileOutputStream

internal class QrCodeGeneratorTest {

    @Test
    fun generate() {
        with (QrCodeGenerator()) {

            generate("Test", FileOutputStream("test.png"))
        }
    }
}