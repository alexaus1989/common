package common.transform


class UUIDTransorm {

    public fun addDashesToUUID(uuid: String): String {
        return uuid.replaceFirst(
            "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})".toRegex(),
            "$1-$2-$3-$4-$5"
        )
    }
}