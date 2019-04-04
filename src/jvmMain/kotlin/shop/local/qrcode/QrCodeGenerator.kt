package shop.local.qrcode

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import java.io.OutputStream


class QrCodeGenerator {

    fun generate(uuid : String, outputStream: OutputStream) {
        val qrCodeWriter = QRCodeWriter()
        val bitMatrix = qrCodeWriter.encode(uuid, BarcodeFormat.QR_CODE, 350, 350)
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream)
    }
}