package com.goorm.maki.controller

import com.goorm.maki.service.NightTourSpotService
import com.goorm.maki.constant.CategoryEnum
import com.goorm.maki.domain.dto.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@Tag(name = "야간관광명소", description = "야간 관광명소 API")
@RestController
@RequestMapping("/api/v1/night-tour")
class NightTourSpotController(
    private val service: NightTourSpotService
) {

    @GetMapping
    @Operation(summary = "야간 관광명소 목록 조회", description = "야간 관광명소를 조회하는 API입니다.")
    fun findNightTour(): List<RecommendTourListDTO> = service.findNightTour()

    @PostMapping
    @Operation(summary = "야간 관광명소 등록", description = "야간 관광명소를 등록하는 API입니다.")
    fun createNightTour(@RequestBody nightTourRequestDto: NightTourRequestDto): NightTourDTO {
        return service.createNightTour(nightTourRequestDto)
    }

    @PostMapping(
        "/upload-pic",
        consumes = ["multipart/form-data"]
    )
    @Operation(summary = "야간 관광명소 이미지 등록", description = "야간 관광명소 이미지를 등록하는 API입니다.")
    fun createNightTourPic(@RequestParam("file") file: MultipartFile): NightTourPicDTO =
        service.createNightTourPic(file)

}