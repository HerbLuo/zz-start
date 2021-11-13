package cn.cloudself.start.interactive

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/react-action")
class ReactResponseController {
    @GetMapping("/run")
    fun run() {

    }
}
