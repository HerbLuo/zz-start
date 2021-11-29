package cn.cloudself.start.interactive

import cn.cloudself.start.interactive.util.runMethod
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/interactive")
class InteractiveResponseController {
    @PostMapping("/callback/{methodInfo}", produces = ["application/json;charset=utf-8"])
    fun run(@PathVariable methodInfo: String, @RequestBody body: Map<String, Any?>): Any? {
        return runMethod(methodInfo, body)
    }
}
