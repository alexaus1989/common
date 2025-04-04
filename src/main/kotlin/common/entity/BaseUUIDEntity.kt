package traffus.blog.traffus_blog.base.entity

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.util.*

@MappedSuperclass
open class BaseUUIDEntity(
    @Id
    @GeneratedValue
    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    open var uuid: UUID? = null
) : BaseEntity()

