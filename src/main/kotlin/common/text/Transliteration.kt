package traffus.blog.traffus_blog.base.text

import java.util.*
import com.ibm.icu.text.Transliterator

class Transliteration (){

    private val toLatinTransliterator = Transliterator.getInstance("Russian-Latin/BGN")

    public fun transliterateToAscii(input: String): String {

        return toLatinTransliterator.transliterate(input)
            .replace(" ", "_")
            .toLowerCase() + "_" + UUID.randomUUID().toString()
    }

    public fun transliterateToAsciiNotUUID(input: String): String {

        return toLatinTransliterator.transliterate(input)
            .replace(" ", "_")
            .toLowerCase()
    }
    
}