package shop.local.customerui.common

import shop.local.customerui.admin.CustomerPointsReader
import shop.local.customerui.admin.CustomerPointsWriter
import shop.local.customerui.admin.QrCode
import shop.local.models.Customer
import shop.local.models.Points
import shop.local.models.Shop

class Scanner(private val reader : CustomerReader,
              private val shop : Shop,
              private val customerPointsReader: CustomerPointsReader,
              private val customerPointsWriter: CustomerPointsWriter
) {

    fun scan(qrCode: QrCode) : Customer {
        return reader.customerForQrCode(qrCode)
    }

    fun scanForPoints(qrCode: QrCode) : List<Points> {
        return customerPointsReader.pointsForCustomerShop(scan(qrCode), shop)
    }

    fun scanToAddPoints(qrCode: QrCode, points : Points) {
        return customerPointsWriter.addPoints(scan(qrCode), shop, points)
    }
}