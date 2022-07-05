select id, #字典编号 number
       id as id_1, #字典编号1 number
       id as `id_2`, #字典编号2 number
       name, #字典名称
       type, #字典类型
       sys_dict_type.status, #状态 status
       sys_dict_type.`create_time`, #创建时间 datetime
       sys_dict_type.remark as remark #备注
from sys_dict_type
where deleted = false

