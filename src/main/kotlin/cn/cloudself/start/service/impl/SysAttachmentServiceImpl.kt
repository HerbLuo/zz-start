package cn.cloudself.start.service.impl

import cn.cloudself.start.dao.SysAttachmentQueryPro
import cn.cloudself.start.entity.SysAttachmentEntity
import cn.cloudself.start.exception.http.RequestNotFindException
import cn.cloudself.start.exception.http.ServerException
import cn.cloudself.start.service.ISysAttachmentService
import cn.cloudself.start.util.Sha256WithRsa
import cn.cloudself.start.util.i18n
import org.springframework.stereotype.Service
import org.springframework.util.FileCopyUtils
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.UnsupportedEncodingException
import java.lang.Exception
import java.math.BigInteger
import java.net.URLEncoder
import java.security.MessageDigest
import java.util.regex.Pattern

/**
 * 附件服务
 * @author hb
 */
@Service
class SysAttachmentServiceImpl : ISysAttachmentService {
    override fun getAttachments(business: String, businessId: Long): List<SysAttachmentEntity> {
        return SysAttachmentQueryPro.selectBy().business.equalsTo(business).and().businessId.equalsTo(businessId).run()
    }

    override fun update(attachment: SysAttachmentEntity): Boolean {
        return SysAttachmentQueryPro.updateSet(attachment, false).run()
    }

    override fun remove(attachmentId: Long): Boolean {
        return SysAttachmentQueryPro.deleteByPrimaryKey(attachmentId)
    }

    override fun upload(business: String, businessId: Long, file: MultipartFile): SysAttachmentEntity {
        return upload(business, businessId, file, false)
    }

    override fun uploadOrReplace(business: String, businessId: Long, file: MultipartFile): SysAttachmentEntity {
        return upload(business, businessId, file, true)
    }

    override fun genUrl(attachment: SysAttachmentEntity): String {
        val expire = EXPIRE_MILLIS + System.currentTimeMillis()
        val sha256 = attachment.hash
        val signature: String = try {
            Sha256WithRsa.sign(expire.toString() + sha256)
        } catch (e: Exception) {
            e.printStackTrace()
            throw ServerException(i18n("签名失败"))
        }
        val signatureUrlEncoded: String = try {
            URLEncoder.encode(signature, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            throw ServerException(i18n("URL编码失败"))
        }
        return "/attachments/" + sha256 + "/" + attachment.name + "?expire=" + expire + "&sign=" + signatureUrlEncoded
    }

    override fun getAttachmentCount(business: String, businessId: Long): Int {
        return SysAttachmentQueryPro.selectBy().business.equalsTo(business).and().businessId.equalsTo(businessId).count()
    }

    override fun getAttachmentsCount(business: String, businessIds: Array<Long>): Map<Long, Int> {
        return businessIds.associateWith { getAttachmentCount(business, it) }
    }

    override fun getAttachmentUrl(attachmentId: Long): String {
        val attachment: SysAttachmentEntity = SysAttachmentQueryPro.selectBy().id.equalsTo(attachmentId).runLimit1()
            ?: throw RequestNotFindException(i18n("找不到该附件，id: {}", attachmentId))
        return genUrl(attachment)
    }

    override fun getAttachmentUrl(business: String, businessId: Long): List<String> {
        return SysAttachmentQueryPro
            .selectBy().business.equalsTo(business)
            .and().businessId.equalsTo(businessId)
            .run()
            .map { genUrl(it) }
    }

    override fun getAttachmentUrlLimit1(business: String, businessId: Long): String? {
        val attachment = SysAttachmentQueryPro
            .selectBy().business.equalsTo(business)
            .and().businessId.equalsTo(businessId)
            .runLimit1()
            ?: return null
        return genUrl(attachment)
    }

    private fun upload(business: String, businessId: Long, file: MultipartFile, withReplace: Boolean): SysAttachmentEntity {
        val fileBytes = file.bytes
        val digest: MessageDigest = MessageDigest.getInstance("SHA-256")
        val sha256 = BigInteger(1, digest.digest(fileBytes)).toString(16)
        FileCopyUtils.copy(fileBytes, FileOutputStream(ATTACHMENT_DIR + sha256))
        val attachment = SysAttachmentEntity()
        attachment.name = normalizingFilename(file.originalFilename ?: "unnamed")
        attachment.size = file.size
        attachment.business = business
        attachment.businessId = businessId
        attachment.hash = sha256
        if (withReplace) {
            val oldAtt = SysAttachmentQueryPro
                .selectBy().business.equalsTo(business)
                .and().businessId.equalsTo(businessId)
                .runLimit1()
            if (oldAtt == null) {
                attachment.id = SysAttachmentQueryPro.insert(attachment)
            } else {
                attachment.id = oldAtt.id
                SysAttachmentQueryPro.updateSet(attachment).run()
            }
        } else {
            attachment.id = SysAttachmentQueryPro.insert(attachment)
        }
        return attachment
    }

    private fun normalizingFilename(filename: String): String {
        return NOT_VALID_FILENAME_REG.matcher(filename).replaceAll("_")
    }

    companion object {
        private const val EXPIRE_MILLIS = (1000 * 60 * 10).toLong()
        private val NOT_VALID_FILENAME_REG = Pattern.compile("[^-~()\\[\\]{}.0-9a-zA-Z\\u00FF-\\uFFFF]")
        private val ATTACHMENT_DIR = System.getProperty("user.home") + "/attachments/"

        init {
            File(ATTACHMENT_DIR).mkdirs()
        }
    }
}