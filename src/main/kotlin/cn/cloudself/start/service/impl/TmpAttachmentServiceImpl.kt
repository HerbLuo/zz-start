package cn.cloudself.start.service.impl

import cn.cloudself.start.pojo.Attachment
import cn.cloudself.start.service.IAttachmentService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class TmpAttachmentServiceImpl : IAttachmentService {
    override fun getAttachments(business: String, businessId: Long): List<Attachment> {
        TODO("Not yet implemented")
    }

    override fun update(attachment: Attachment): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(attachmentId: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun upload(business: String, businessId: Long, file: MultipartFile): Attachment {
        TODO("Not yet implemented")
    }

    override fun uploadOrReplace(business: String, businessId: Long, file: MultipartFile): Attachment {
        TODO("Not yet implemented")
    }

    override fun getAttachmentCount(business: String, businessId: Long): Int {
        TODO("Not yet implemented")
    }

    override fun getAttachmentsCount(business: String, businessIds: Array<Long>): Map<Long, Int> {
        TODO("Not yet implemented")
    }

    override fun genUrl(attachment: Attachment): String {
        TODO("Not yet implemented")
    }

    override fun getAttachmentUrl(attachmentId: Long): String {
        TODO("Not yet implemented")
    }

    override fun getAttachmentUrl(business: String, businessId: Long): List<String> {
        TODO("Not yet implemented")
    }

    override fun getAttachmentUrlLimit1(business: String, businessId: Long): String {
        TODO("Not yet implemented")
    }
}