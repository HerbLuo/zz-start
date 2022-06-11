package cn.cloudself.start.controller

import cn.cloudself.start.pojo.UsernamePassword
import cn.cloudself.start.service.ISysAuthService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalTime
import java.util.*


data class Foo(
    val b: Boolean,
    val i: Int,
    val f: Float,
    val d: Double,
    val bc: BigDecimal,
    val date: Date,
    val date2: Timestamp,
    val date3: LocalTime,
    val date4: LocalDate,

    val s: String,
    val m: Map<String, String>,
    val m2: Map<String, Int>,
    val m3: Map<String, Any>,
    val l: List<String>,
    val l2: List<Int>,
    val l3: List<Any>,
    val l4: List<List<Boolean>>,
    val l5: List<Map<String, Int>>,

    val re: UsernamePassword,
    val res: List<UsernamePassword>,
    val timestamps: List<Timestamp>,
)

@RestController
@RequestMapping("/foo")
class FooController @Autowired constructor(
    private val authService: ISysAuthService
) {
    @GetMapping("/{id}/")
    fun get(@PathVariable id: Long): Foo? = null

    @DeleteMapping("/{id}/")
    fun del(@PathVariable id: Long): Boolean = true

    @PostMapping("/")
    fun save(@RequestBody foo: Foo): Foo = foo

    @PutMapping("/")
    fun put(@RequestBody foo: Foo) = true

    @PatchMapping("/")
    fun patch(@RequestBody foo: Foo) = true

    @PostMapping("/mul/")
    fun postMul(@RequestBody foos: List<Foo>): List<Foo> = foos;

    @PostMapping("/str1/{str1}/long1/{long1}/longs1/{longs1}")
    fun postAll(@PathVariable str1: String, @PathVariable long1: Long, @PathVariable longs1: Array<Long>, @RequestBody foo: Foo): Map<String, Foo> {
        return mutableMapOf()
    }

    @PostMapping("/map/")
    fun postAsMap(@RequestBody foo: Map<String, Foo?>) = foo

    @PostMapping("/map-form/")
    fun postAsMapForm(foo: Map<String, Any?>) = foo

    @PostMapping("/form/")
    fun postByForm(foo: Foo, @RequestParam("file") file: MultipartFile) = foo
}
