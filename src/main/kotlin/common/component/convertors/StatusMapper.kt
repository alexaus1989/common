package traffus.blog.traffus_blog.base.component.convertors

import org.springframework.stereotype.Component
import traffus.blog.traffus_blog.Status as GrpcStatus // gRPC enum
import traffus.blog.traffus_blog.base.enums.Status as DomainStatus // Kotlin enum

@Component
class StatusMapper {

    fun toGrpc(status: DomainStatus?): GrpcStatus {
        return when (status) {
            DomainStatus.ACTIVE -> GrpcStatus.ACTIVE
            DomainStatus.NOT_ACTIVE -> GrpcStatus.NOT_ACTIVE
            DomainStatus.DELETED -> GrpcStatus.DELETED
            null -> GrpcStatus.ACTIVE
        }
    }

    fun fromGrpc(status: GrpcStatus?): DomainStatus {
        return when (status) {
            GrpcStatus.ACTIVE -> DomainStatus.ACTIVE
            GrpcStatus.NOT_ACTIVE -> DomainStatus.NOT_ACTIVE
            GrpcStatus.DELETED -> DomainStatus.DELETED
            null -> DomainStatus.ACTIVE
            else -> {
                DomainStatus.ACTIVE
            }
        }
    }
}
