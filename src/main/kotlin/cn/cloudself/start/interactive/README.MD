`interactive`模块允许`Controller`中返回一个可交互的对象。

下面是一些示例和说明，更多示例可以参考`interactive.test.InteractiveTester.kt`

#### 1. 确认框：`interactive.res.Confirm`
使用方法：
```kotlin
return Confirm(
    "确认删除",
    onOk = IService::aFunction,
    onNo = null
)
```
`Confirm`的其中一个构造方法，接受三个参数，

第一个参数是标题，

第二个参数指示用户点击`是`之后的处理方法

第三个参数指示用户点击`否`之后的处理方法, 可为空，代表无操作

