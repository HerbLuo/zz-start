import cn.cloudself.query.util.DbInfoBuilder
import cn.cloudself.query.util.DbNameToJava
import cn.cloudself.query.util.PathFrom
import cn.cloudself.query.util.QueryProFileMaker

val entityExMethods =
    "    fun <T> copyTo(clazz: Class<T>) = clazz.getDeclaredConstructor().newInstance().also { BeanUtils.copyProperties(this, it) }"

QueryProFileMaker
    .entityAndDaoMode(PathFrom.create().ktPackageName("cn.cloudself.start").daoPackage("dao").getResolver())
    /* 指定数据源 */
    .db(DbInfoBuilder.mysql("127.0.0.1", "zz_start").toDbInfo("root", "123456"))
    .dbJavaNameConverter(DbNameToJava.createDefault().addSuffixToEntity("Entity").getConverter())
    .tables("*")
    .replaceMode()
    .swaggerSupport(true)
    .entityExMethods(entityExMethods)
    .disableKtNoArgMode()
    .debug()
    .create()
