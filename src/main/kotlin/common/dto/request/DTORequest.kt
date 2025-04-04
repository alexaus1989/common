package traffus.blog.traffus_blog.base.dto.request

import traffus.blog.traffus_blog.base.enums.SourceRequest
import traffus.blog.traffus_blog.base.enums.TypeDTO

open class DTORequest(
    val sourceRequest: SourceRequest? = null,
    var typeDTO: TypeDTO? = null
)
