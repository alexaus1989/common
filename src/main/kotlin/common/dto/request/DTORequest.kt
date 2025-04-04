package common.dto.request

import common.enums.SourceRequest
import common.enums.TypeDTO

open class DTORequest(
    val sourceRequest: SourceRequest? = null,
    var typeDTO: TypeDTO? = null
)
