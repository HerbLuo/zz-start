package cn.cloudself.start.controller

import cn.cloudself.start.entity.SysAttachmentEntity
import cn.cloudself.start.service.ISysAttachmentService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@Api(tags = ["附件"])
@RestController
@RequestMapping("/attachment")
class SysAttachmentController @Autowired constructor(
    private val attachmentService: ISysAttachmentService,
) {
    @ApiOperation(value = "获取附件列表")
    @GetMapping("/business/{business}/id/{businessId}")
    fun listAttachment(@PathVariable business: String, @PathVariable businessId: Long): List<SysAttachmentEntity> {
        return attachmentService.getAttachments(business, businessId)
    }

    @ApiOperation(value = "获取附件条数")
    @GetMapping("/business/{business}/id/{businessId}/count")
    fun getAttachmentCount(@PathVariable business: String, @PathVariable businessId: Long): Int {
        return attachmentService.getAttachmentCount(business, businessId)
    }

    @ApiOperation(value = "批量获取附件条数")
    @GetMapping("/business/{business}/ids/{businessIds}/count")
    fun getAttachmentCount(@PathVariable business: String, @PathVariable businessIds: Array<Long>): Map<Long, Int> {
        return attachmentService.getAttachmentsCount(business, businessIds)
    }

    @ApiOperation(value = "获取某业务的单个附件的url")
    @GetMapping("/business/{business}/id/{businessId}/url-limit-1")
    fun getAttachmentUrlLimit1(@PathVariable business: String, @PathVariable businessId: Long): String? {
        return attachmentService.getAttachmentUrlLimit1(business, businessId)
    }

    @ApiOperation(value = "获取单个附件的url")
    @GetMapping("/{id}/url")
    fun getAttachmentUrl(@PathVariable id: Long): String {
        return attachmentService.getAttachmentUrl(id)
    }

    @ApiOperation(value = "更新附件", produces = "application/json")
    @PutMapping("")
    fun updateAttachment(@RequestBody attachment: SysAttachmentEntity): Boolean {
        return attachmentService.update(attachment)
    }

    @ApiOperation(value = "删除附件")
    @DeleteMapping("/{id}")
    fun removeAttachment(@PathVariable id: Long): Boolean {
        return attachmentService.remove(id)
    }

    @ApiOperation(value = "上传附件")
    @PostMapping("/business/{business}/id/{businessId}")
    fun saveAttachment(
        @PathVariable business: String,
        @PathVariable businessId: Long,
        @RequestParam("file") file: MultipartFile
    ): SysAttachmentEntity {
        return attachmentService.upload(business, businessId, file)
    }

    @ApiOperation(value = "上传或替换附件")
    @PostMapping("/upload-or-replace/business/{business}/id/{businessId}")
    fun uploadOrReplaceAttachment(
        @PathVariable business: String,
        @PathVariable businessId: Long,
        @RequestParam("file") file: MultipartFile
    ): SysAttachmentEntity {
        return attachmentService.uploadOrReplace(business, businessId, file)
    }
}