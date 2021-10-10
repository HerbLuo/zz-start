package cn.cloudself

import cn.cloudself.query.util.PathFrom
import cn.cloudself.query.util.QueryProFileMaker
import org.junit.jupiter.api.Test

class Misc {
    @Test
    fun test() {
        QueryProFileMaker
            .singleFileMode(PathFrom.ktPackage("cn.cloudself.start"))
            .create()
    }
}
