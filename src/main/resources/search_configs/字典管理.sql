select id, #字典编号 number
       name, #字典名称
       type, #字典类型
       status, #状态 options values=状态
       create_time, #创建时间 datetime
       remark #备注
from sys_dict_type
where deleted = false
