package com.pujaditya.foodmarket.utils

import android.widget.TextView
import java.text.DecimalFormat

object Helpers {
    fun TextView.formatPrice(value: String) {
        if (value.isNotEmpty()) {
            val doubleValue = try {
                value.toDouble()
            } catch (e: NumberFormatException) {
                0.0 // Atau nilai default lainnya jika konversi gagal
            }
            this.text = getCurrencyIDR(doubleValue)
        } else {
            this.text = "IDR 0" // Nilai default jika string kosong
        }
    }

    fun getCurrencyIDR (price : Double) : String {
        val format = DecimalFormat("#,###,###")
        return  "IDR "+format.format(price).replace(",".toRegex(), ".")
    }
}