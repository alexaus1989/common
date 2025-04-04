package traffus.blog.traffus_blog.base.entity

import traffus.blog.traffus_blog.base.entity.BaseEntity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
open class BaseIDEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long,
) : BaseEntity() {
    constructor() : this(id = 0)
}

