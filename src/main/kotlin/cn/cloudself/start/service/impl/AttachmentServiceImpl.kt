//package cn.cloudself.start.service.impl
//
//import cn.cloudself.start.exception.http.RequestNotFindException
//import cn.cloudself.start.exception.http.ServerException
//import cn.cloudself.start.pojo.Attachment
//import cn.cloudself.start.service.IAttachmentService
//import cn.cloudself.start.util.Sha256WithRsa
//import org.springframework.stereotype.Service
//import org.springframework.util.FileCopyUtils
//import org.springframework.web.multipart.MultipartFile
//import java.io.File
//import java.io.FileOutputStream
//import java.io.UnsupportedEncodingException
//import java.lang.Exception
//import java.math.BigInteger
//import java.net.URLEncoder
//import java.security.MessageDigest
//import java.util.regex.Pattern
//
///**
// * 附件服务
// * @author hb
// */
//@Service
//class AttachmentServiceImpl : IAttachmentService {
//    override fun getAttachments(business: String, businessId: Long): List<Attachment> {
//        val attachmentFastDAO: AttachmentFastDAO = AttachmentFastDAO.create()
//        attachmentFastDAO.business(business)
//        attachmentFastDAO.businessId(businessId)
//        return attachmentFastDAO.dao().findAll()
//    }
//
//    override fun update(attachment: Attachment): Boolean {
//        val c: Int = AttachmentFastDAO.create().dao().update(attachment)
//        return c > 0
//    }
//
//    override fun remove(attachmentId: Long): Boolean {
//        return AttachmentFastDAO.create().dao().deleteByPrimaryKey(attachmentId)
//    }
//
//    override fun upload(business: String, businessId: Long, file: MultipartFile): Attachment {
//        return upload(business, businessId, file, false)
//    }
//
//    override fun uploadOrReplace(business: String, businessId: Long, file: MultipartFile): Attachment {
//        return upload(business, businessId, file, true)
//    }
//
//    override fun genUrl(attachment: Attachment): String {
//        val expire = EXPIRE_MILLIS + System.currentTimeMillis()
//        val sha256 = attachment.sha256
//        val signature: String = try {
//            Sha256WithRsa.sign(expire.toString() + sha256)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            throw ServerException("签名失败")
//        }
//        val signatureUrlEncoded: String = try {
//            URLEncoder.encode(signature, "UTF-8")
//        } catch (e: UnsupportedEncodingException) {
//            e.printStackTrace()
//            throw ServerException("URL编码失败")
//        }
//        return "/attachments/" + sha256 + "/" + attachment.name + "?expire=" + expire + "&sign=" + signatureUrlEncoded
//    }
//
//    override fun getAttachmentCount(business: String, businessId: Long): Int {
//        val attachmentFastDAO: AttachmentFastDAO = AttachmentFastDAO.create()
//        attachmentFastDAO.business(business)
//        attachmentFastDAO.businessId(businessId)
//        return attachmentFastDAO.dao().findCount()
//    }
//
//    override fun getAttachmentsCount(business: String, businessIds: Array<Long>): Map<Long, Int> {
//        return businessIds.map { it to getAttachmentCount(business, it) }.toMap();
//    }
//
//    override fun getAttachmentUrl(attachmentId: Long): String {
//        val attachment: Attachment = AttachmentFastDAO.create().dao().findByPrimaryKey(attachmentId)
//            ?: throw RequestNotFindException("找不到该附件, id: $attachmentId")
//        return genUrl(attachment)
//    }
//
//    override fun getAttachmentUrl(business: String, businessId: Long): List<String> {
//        val attachmentFastDAO: AttachmentFastDAO = AttachmentFastDAO.create()
//        attachmentFastDAO.business(business)
//        attachmentFastDAO.businessId(businessId)
//        return attachmentFastDAO.dao().findAll().stream().map(genUrl).collect(Collectors.toList())
//    }
//
//    override fun getAttachmentUrlLimit1(business: String, businessId: Long): String {
//        val attachmentFastDAO: AttachmentFastDAO = AttachmentFastDAO.create()
//        attachmentFastDAO.business(business)
//        attachmentFastDAO.businessId(businessId)
//        val attachment: Attachment = attachmentFastDAO.dao().findOne()
//            ?: return null
//        return genUrl(attachment)
//    }
//
//    private fun upload(business: String, businessId: Long, file: MultipartFile, withReplace: Boolean): Attachment {
//        val fileBytes = file.bytes
//        val digest: MessageDigest = MessageDigest.getInstance("SHA-256")
//        val sha256 = BigInteger(1, digest.digest(fileBytes)).toString(16)
//        FileCopyUtils.copy(fileBytes, FileOutputStream(ATTACHMENT_DIR + sha256))
//        val attachment = Attachment()
//        attachment.name = normalizingFilename(file.originalFilename ?: "unnamed")
//        attachment.size = file.size
//        attachment.business = business
//        attachment.businessId = businessId
//        attachment.sha256 = sha256
//        return if (withReplace) {
//            val attachmentFastDAO: AttachmentFastDAO = AttachmentFastDAO.create()
//            attachmentFastDAO.business(business)
//            attachmentFastDAO.businessId(businessId)
//            val oldAtt: Attachment = attachmentFastDAO.dao().findOne()
//            if (oldAtt == null) {
//                AttachmentFastDAO.create().dao().insert(attachment)
//            } else {
//                attachment.setId(oldAtt.getId())
//                AttachmentFastDAO.create().dao().updateByPrimaryKey(attachment)
//                attachment
//            }
//        } else {
//            AttachmentFastDAO.create().dao().insert(attachment)
//        }
//    }
//
//    private fun normalizingFilename(filename: String): String {
//        return NOT_VALID_FILENAME_REG.matcher(filename).replaceAll("_")
//    }
//
//    companion object {
//        private const val EXPIRE_MILLIS = (1000 * 60 * 10).toLong()
//        private val NOT_VALID_FILENAME_REG = Pattern.compile("[^-~()\\[\\]{}.0-9a-zA-Z\\u00FF-\\uFFFF]")
//        private val ATTACHMENT_DIR = System.getProperty("user.home") + "/attachments/"
//
//        init {
//            File(ATTACHMENT_DIR).mkdirs()
//        }
//    }
//}