select ele.id, #字典编号 number
       tag_cn, #名称
       alias, # 字段名
       alias_cn,
       ele.`sql`,

       ele.status, #状态 options values=状态
       ele.`create_time`, #创建时间 datetime
       ele.remark as remark #备注
from sys_query_element ele
    left join sys_query on ele.sys_query_id = sys_query.id
where sys_query.deleted = false and ele.deleted = false
