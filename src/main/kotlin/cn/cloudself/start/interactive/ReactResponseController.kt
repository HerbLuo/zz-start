package cn.cloudself.start.interactive

import cn.cloudself.start.interactive.util.invoke
import cn.cloudself.start.interactive.util.parseUrlPartToSerializedStr
import cn.cloudself.start.interactive.util.runMethod
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/interactive")
class ReactResponseController {
    @GetMapping("/callback/{methodInfo}")
    fun run(@PathVariable methodInfo: String, @RequestBody body: Map<String, Any?>): Any? {
        return runMethod(methodInfo, body)
    }
}
