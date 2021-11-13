package cn.cloudself.start.util

import org.apache.commons.io.FileUtils
import java.io.File
import java.nio.charset.StandardCharsets
import java.security.*
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher

interface ISha256WithRsa {
    fun sign(str: String): String
    fun valid(str: String, sign: String?): Boolean
    fun encrypt(str: String): String
    fun decrypt(str: String): String
}

private fun create(name: String? = null): Sha256WithRsa {
    val keyDir = System.getProperty("user.home") + "/.java/zz-start/" + if (name != null) "$name/" else ""
    val publicKeyPath = keyDir + "public_key"
    val privateKeyPath = keyDir + "private_key"

    File(keyDir).mkdirs()

    val publicKeyFile = File(publicKeyPath)
    val privateKeyFile = File(privateKeyPath)

    val publicKey: PublicKey
    val privateKey: PrivateKey
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

    return Sha256WithRsa(publicKey, privateKey)
}

/**
 * @author herbluo
 */
class Sha256WithRsa constructor(
    private val publicKey: PublicKey,
    private val privateKey: PrivateKey,
): ISha256WithRsa {
    companion object : ISha256WithRsa by create() {
        fun create(name: String) = cn.cloudself.start.util.create(name)
    }

    override fun sign(str: String): String {
        val signature = Signature.getInstance("SHA256withRSA")
        signature.initSign(privateKey)
        signature.update(str.toByteArray(StandardCharsets.UTF_8))
        val signBytes = signature.sign()
        return Base64.getEncoder().encodeToString(signBytes)
    }

    override fun valid(str: String, sign: String?): Boolean {
        val signature = Signature.getInstance("SHA256withRSA")
        signature.initVerify(publicKey)
        signature.update(str.toByteArray(StandardCharsets.UTF_8))
        return signature.verify(Base64.getDecoder().decode(sign))
    }

    override fun encrypt(str: String): String {
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        val encryptBytes = cipher.doFinal(str.toByteArray(StandardCharsets.UTF_8))
        return Base64.getEncoder().encodeToString(encryptBytes)
    }

    override fun decrypt(str: String): String {
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.DECRYPT_MODE, privateKey)
        val decryptBytes = cipher.doFinal(Base64.getDecoder().decode(str))
        return String(decryptBytes)
    }
}
