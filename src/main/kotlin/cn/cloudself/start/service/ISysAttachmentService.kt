package cn.cloudself.start.service

import cn.cloudself.start.entity.AttachmentEntity
import org.springframework.web.multipart.MultipartFile
import java.io.IOException

/**
 * 附件服务
 * @author hb
 */
interface ISysAttachmentService {
    /**
     * 获取附件
     * @param business 业务
     * @param businessId 业务id
     * @return 附件列表
     */
    fun getAttachments(business: String, businessId: Long): List<AttachmentEntity>

    /**
     * 更新附件信息（用于重命名等）
     * @param attachment 附件
     * @return 是否更新成功
     */
    fun update(attachment: AttachmentEntity): Boolean

    /**
     * 删除附件
     * @param attachmentId 附件id
     * @return 是否删除成功
     */
    fun remove(attachmentId: Long): Boolean

    /**
     * 上传单个附件
     * @param business 业务名
     * @param businessId 业务id
     * @param file .
     * @return 附件信息
     * @throws IOException .
     */
    fun upload(business: String, businessId: Long, file: MultipartFile): AttachmentEntity

    /**
     * 上传或替换单个附件
     * @param business 业务名
     * @param businessId 业务id
     * @param file .
     * @return 附件信息
     * @throws IOException .
     */
    fun uploadOrReplace(business: String, businessId: Long, file: MultipartFile): AttachmentEntity

    /**
     * 获取附件条数 这里无关附件使用组织权限
     *
     * @param business 业务
     * @param businessId 业务id
     * @return 附件条数
     */
    fun getAttachmentCount(business: String, businessId: Long): Int

    /**
     * 批量获取附件条数 这里无关附件使用组织权限
     * <businessId></businessId>, count>
     *
     * @param business 业务
     * @return 附件条数
     */
    fun getAttachmentsCount(business: String, businessIds: Array<Long>): Map<Long, Int>

    /**
     * 生成附件url
     * @param attachment 附件
     * @return url
     */
    fun genUrl(attachment: AttachmentEntity): String

    /**
     * 获取附件地址
     * @param attachmentId 附件id
     * @return url(不含前缀)
     */
    fun getAttachmentUrl(attachmentId: Long): String

    /**
     * 获取附件地址
     * @param business 业务
     * @param businessId 业务id
     * @return url
     */
    fun getAttachmentUrl(business: String, businessId: Long): List<String>

    /**
     * 获取附件地址Limit1
     * @param business 业务
     * @param businessId 业务id
     * @return url
     */
    fun getAttachmentUrlLimit1(business: String, businessId: Long): String?
}