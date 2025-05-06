package common.text

import java.util.*
import com.ibm.icu.text.Transliterator

class Transliteration {

    private val toLatinTransliterator = Transliterator.getInstance("Russian-Latin/BGN")

    fun transliterateToAscii(input: String): String {
        return clean(toLatinTransliterator.transliterate(input)) + "_" + UUID.randomUUID().toString()
    }

    fun transliterateToAsciiNotUUID(input: String): String {
        return clean(toLatinTransliterator.transliterate(input))
    }

    private fun clean(text: String): String {
        return text
            .lowercase()
            .replace(" ", "_")                         // пробелы → подчёркивания
            .replace(Regex("[^a-z0-9_-]"), "")         // всё, что не латиница, цифра, `_` или `-`, удаляется
            .replace(Regex("_+"), "_")                 // двойные/тройные подчёркивания → одно
            .trim('_')                                 // убрать подчёркивания по краям
    }
}
