`interactive`模块允许`Controller`中返回一个可交互的对象。

下面是一些示例和说明，更多示例可以参考`interactive.test.InteractiveTester.kt`

### 用法：

#### 1. 确认框：`interactive.res.Confirm`
##### 1) 使用方法：
```kotlin
interface IService {
    fun onOk(arg1: String, arg2: Int)
}

class AnotherService {
    fun func(): Confirm {
        return Confirm(
            "确认删除?",
            onOk = IService::onOk,
            onNo = null
        )
    }
}
```
`Confirm`的其中一个构造方法，接受三个参数，

第一个参数是标题，

第二个参数指示用户点击`是`之后的处理方法

第三个参数指示用户点击`否`之后的处理方法, 可为空，代表无操作

##### 2) 返回结果
经过`InteractiveResponseAdvice`自动处理后，返回结果会被转换成
```json5
{
  "confirm": "确认删除?",
  "okText": "是",
  "okUrl": {
    "url": "http(s)://host:port/interactive/callback/<自动生成的方法信息>", // http(s)请求地址, 方法为POST, 该地址为自动生成的, 对该地址发起请求，会调用IService::onOk方法(Confirm的第二个参数onOk)
    "argNames": ["arg1", "arg2"] // 上述地址的参数：对应的请求体为{"arg1": "", "arg2": 0}
  },
  "noText": "否",
  "noUrl": null
}
```

对应的前端自动处理工具已完成, 参考: 

#### 1. Promise：`interactive.res.Promise`
`Promise` 用于立刻返回一个需要较长时间执行的操作。
##### 1) 使用方法：

```java
import cn.cloudself.start.interactive.res.Promise;

import java.util.List;
import java.util.ArrayList;

class PageData {
    private List<Map<String, Object>> rows;
    private Boolean hasNext;
    private Promise<Int> totalCount;

    public PageData(List<Map<String, Object>> rows, Boolean hasNext, Promise<Int> totalCount) {
        this.rows = rows;
        this.hasNext = hasNext;
        this.totalCount;
    }
}

class Service {
    public PageData getPage(Integer page, Integer pageSize) {
        final Integer start = (page - 1) * pageSize;
        List<Map<String, Object>> rows = selectRows(start, pageSize + 1);
        final boolean hasNext;
        if (rows.size() > pageSize) {
            hasNext = true;
            rows = rows.subList(0, pageSize);
        } else {
            hasNext = false;
        }

        final Promise<Int> totalCountPromise = hasNext
                ? Promise.create(this::getTotalCount)
                : Promise.resolve(page * pageSize + rows.size());
        return new PageData(rows, hasNext, totalCountPromise);
    }

    private List<Map<String, Object>> selectRows(Integer start, Integer limit) {
        // some sql query
    }

    private Integer getTotalCount() {
        // some sql query
    }
}
```
