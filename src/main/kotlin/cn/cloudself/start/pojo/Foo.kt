package cn.cloudself.start.pojo

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
)
