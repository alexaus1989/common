package common.mappers

import common.dto.response.ResultResponseDTO
import common.enums.Status
import traffus.common.ResultResponse
import traffus.common.Status as GrpcStatus // gRPC enum


class ResultResposeMapper {

    fun toGrpc(result: ResultResponseDTO): ResultResponse {
        return ResultResponse.newBuilder()
            .setResult(result.result)
            .build()
    }

    fun fromGrpc(result: ResultResponse?): ResultResponseDTO {
        return ResultResponseDTO(
            result =  result!!.result,
        )
    }
}
