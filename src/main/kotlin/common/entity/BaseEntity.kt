package common.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import common.enums.Status
import java.io.Serializable
import java.util.*

@MappedSuperclass
abstract class BaseEntity(
    @CreatedDate
    @Column(name = "created_at")
    open var created: Date? = Date(),

    @LastModifiedDate
    @Column(name = "updated_at")
    open var updated: Date? = Date(),

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    open var status: Status? = Status.ACTIVE
) : Serializable {
    @PrePersist
    fun prePersist() {
        created = Date()
        updated = Date()
    }

    @PreUpdate
    fun preUpdate() {
        updated = Date()
    }

}
