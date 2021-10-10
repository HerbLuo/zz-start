package cn.cloudself.start.util

import org.apache.commons.io.FileUtils
import java.io.File
import java.nio.charset.StandardCharsets
import java.security.*
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.*

/**
 * @author herbluo
 */
object Sha256WithRsa {
    private val publicKey: PublicKey
    private val privateKey: PrivateKey

    fun sign(str: String): String {
        val signature = Signature.getInstance("SHA256withRSA")
        signature.initSign(privateKey)
        signature.update(str.toByteArray(StandardCharsets.UTF_8))
        val signBytes = signature.sign()
        return Base64.getEncoder().encodeToString(signBytes)
    }

    fun valid(str: String, sign: String?): Boolean {
        val signature = Signature.getInstance("SHA256withRSA")
        signature.initVerify(publicKey)
        signature.update(str.toByteArray(StandardCharsets.UTF_8))
        return signature.verify(Base64.getDecoder().decode(sign))
    }

    private val KEY_DIR = System.getProperty("user.home") + "/.java/zz-start/"
    private val PUBLIC_KEY_PATH = KEY_DIR + "public_key"
    private val PRIVATE_KEY_PATH = KEY_DIR + "private_key"

    init {
        File(KEY_DIR).mkdirs()

        val publicKeyFile = File(PUBLIC_KEY_PATH)
        val privateKeyFile = File(PRIVATE_KEY_PATH)

        if (publicKeyFile.exists() && privateKeyFile.exists()) {
            val publicSpec = X509EncodedKeySpec(Base64.getDecoder().decode(FileUtils.readFileToByteArray(publicKeyFile)))
            val privateSpec = PKCS8EncodedKeySpec(Base64.getDecoder().decode(FileUtils.readFileToByteArray(privateKeyFile)))
            val keyFactory = KeyFactory.getInstance("RSA")
            privateKey = keyFactory.generatePrivate(privateSpec)
            publicKey = keyFactory.generatePublic(publicSpec)
        } else {
            val keyPairGen = KeyPairGenerator.getInstance("RSA")
            keyPairGen.initialize(1024, SecureRandom())
            val keyPair = keyPairGen.genKeyPair()
            publicKey = keyPair.public
            privateKey = keyPair.private

            FileUtils.writeByteArrayToFile(publicKeyFile, Base64.getEncoder().encode(publicKey.encoded))
            FileUtils.writeByteArrayToFile(privateKeyFile, Base64.getEncoder().encode(privateKey.encoded))
        }
    }
}