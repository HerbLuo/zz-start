package cn.cloudself.start.components

data class Res<T> constructor(
  val ok: Byte,
  val data: T
)

fun ok() = Res(1, true)
fun <T>ok(data: T) = Res(1, data)
fun <T: Any>err(error: T) = Res(-1, error)
