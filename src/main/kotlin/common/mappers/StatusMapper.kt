package common.mappers

import common.enums.Status
import common.enums.Status as GrpcStatus // gRPC enum


class StatusMapper {

    fun toGrpc(status: Status?): GrpcStatus {
        return when (status) {
            Status.ACTIVE -> GrpcStatus.ACTIVE
            Status.NOT_ACTIVE -> GrpcStatus.NOT_ACTIVE
            Status.DELETED -> GrpcStatus.DELETED
            null -> GrpcStatus.ACTIVE
        }
    }

    fun fromGrpc(status: GrpcStatus?): Status {
        return when (status) {
            GrpcStatus.ACTIVE -> Status.ACTIVE
            GrpcStatus.NOT_ACTIVE -> Status.NOT_ACTIVE
            GrpcStatus.DELETED -> Status.DELETED
            null -> Status.ACTIVE
            else -> {
                Status.ACTIVE
            }
        }
    }
}
