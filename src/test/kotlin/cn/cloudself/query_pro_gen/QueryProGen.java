package cn.cloudself.query_pro_gen;

import cn.cloudself.query.QueryStructureResolverKt;
import cn.cloudself.query.util.DbInfoBuilder;
import cn.cloudself.query.util.PathFrom;
import cn.cloudself.query.util.QueryProFileMaker;
import cn.cloudself.start.java.dao.zz.AuthPwdQueryPro;
import cn.cloudself.start.java.dao.zz.UserPriQueryPro;
import cn.cloudself.start.java.entity.AuthPwd;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QueryProGen {

    @Test
    public void test() {
        QueryProFileMaker
                .Companion
                /* 将文件生成至 <project>/src/main/kotlin/cn/cloudself/foo/dao/zz下 */
                .javaEntityAndDaoMode(PathFrom.Companion.ktPackage("cn.cloudself.start.java"))
                /* 指定数据源 */
                .db(DbInfoBuilder.Companion.mysql("127.0.0.1", "zz_trans").toDbInfo("root", "123456"))
                /* 如文件已存在, 替换掉已有的文件 默认跳过已存在的文件 */
                .replaceMode(true)
                /* 显示更多输出 */
                .debug()
                .create();
    }

    @Test
    public void test2() {
        final List<AuthPwd> authPwds = AuthPwdQueryPro
                .selectBy().username().equalsTo("testuser")
                .and().password().equalsTo("okk")
                .run();

        AuthPwdQueryPro.EX
                .leftJoinOn(AuthPwdQueryPro.EX.joiner().uid(), UserPriQueryPro.EX.joiner().uid())
                .selectBy().username().equalsTo("testuser")
                .andForeignField(UserPriQueryPro.EX.foreignField().role().equalsTo("1"))
                .run();
    }
}
