package common.transform

import java.util.*


class UUIDTransorm {
    /*
        public fun addDashesToUUID(uuid: String): String {
            return uuid.replaceFirst(
                "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})".toRegex(),
                "$1-$2-$3-$4-$5"
            )
        }*/
    fun addDashesToUUID(uuid: String?): String {
        require(!uuid.isNullOrBlank()) { "UUID string is null or blank" }

        val cleaned = uuid.trim().lowercase()
        require(cleaned != "null") { "UUID string is literal 'null'" }

        return if (cleaned.contains("-")) {
            // UUID уже с тире — проверим, валиден ли
            UUID.fromString(cleaned) // проверка валидности
            cleaned
        } else {
            val regex = "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})".toRegex()
            require(regex.matches(cleaned)) {
                "UUID string does not match expected format (32 hex characters)"
            }
            regex.replace(cleaned, "$1-$2-$3-$4-$5")
        }
    }

}