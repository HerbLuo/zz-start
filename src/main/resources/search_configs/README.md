你只需要在本文件夹下写一个`SELECT`语句，保存为`.sql`文件。
然后执行`CreateSearchConfigDbData.ofResource()`。
就可以生成对应的前端界面，该界面功能丰富，易于扩展。

但是该`SELECT`语句存在一定的限制，
以下简单的说明了对`MySQL` `SELECT`语句的支持情况
```
SELECT
    [ALL | DISTINCT | DISTINCTROW ]
    [HIGH_PRIORITY]
    [STRAIGHT_JOIN]
    [SQL_SMALL_RESULT] [SQL_BIG_RESULT] [SQL_BUFFER_RESULT]
    [SQL_NO_CACHE] [SQL_CALC_FOUND_ROWS]
    select_expr [, select_expr] ...
    [into_option]                                              -- 不支持
    [FROM table_references
      [PARTITION partition_list]]
    [WHERE where_condition]
    [GROUP BY {col_name | expr | position}, ... [WITH ROLLUP]] --不支持
    [HAVING where_condition]                                   --不支持
    [WINDOW window_name AS (window_spec)                       --不支持
        [, window_name AS (window_spec)] ...]                  --
    [ORDER BY {col_name | expr | position}                     --不支持 会自动添加 由前端控制
      [ASC | DESC], ... [WITH ROLLUP]]                         --
    [LIMIT {[offset,] row_count | row_count OFFSET offset}]    --不支持 会自动添加 由分页控制
    [into_option]                                              --不支持
    [FOR {UPDATE | SHARE}                                      --不支持
        [OF tbl_name [, tbl_name] ...]                         --
        [NOWAIT | SKIP LOCKED]                                 --
      | LOCK IN SHARE MODE]                                    --
    [into_option]                                              --不支持
```

针对`UNION`语句:  
因为查询方案会根据用户选择的搜索条件往`SQL`继续拼接`WHERE条件`，  
`UNION语句`无法直接拼接`WHERE条件`，  
所以我们必须识别拆分`UNION语句`，  
识别`UNION语句`只是简单判断了是否存在以`UNION`开头的行，  
所以关键字`UNION`必须置顶。
以下例子说明了什么`union sql`能被正常解析，
```sql
-- 能正常解析
select a 
from db1
 left join (
    select id from db2 union /* 非主语句union不可放在行首 */ select id from db3
 ) v_db on v_db.id = db1.id
where deleted = false
union -- union置顶，可以识别
select a
from db5

-- 不能正常解析
select a
from db1 union -- union必须在行首，该例子不能识别
select a
from db5
```
