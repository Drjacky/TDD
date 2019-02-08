package ir.hosseinabbasi.tdd

import java.io.File

class Utils {

    companion object {

        fun getJson(path: String): String {
            val uri = this.javaClass.classLoader.getResource(path)
            val file = File(uri.path)
            return String(file.readBytes())
        }
    }
}