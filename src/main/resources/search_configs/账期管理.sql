#自动生成的版本信息17
#自定义名称zhang_qi_guan_li
select log.id,#ID hidden=1
       log.kyc_id,#交易对手
       log.kyc_name,#交易对手名称 hidden=1
       contract.no,#合同号
       if(deal.direction = 'P', '采购', '销售') as direction,#方向 values limit=[{"name":"采购","value":"P"},{"name":"销售","value":"S"}]
       deal.business_type,#贸易类型($) values limit=[{"name":"即期","value":"即期"},{"name":"远期","value":"远期"},{"name":"子系列","value":"子系列"}]
       if(deal.direction = 'P', '货物', '账款')                                      as account_period_type_text,#账期类型 values limit=[{"name":"货物","value":"货物"},{"name":"账款","value":"账款"}]
       log.remainder_amount,#金额 number
       log_calc.expire_time                                                              as expire_time, #到期日 date
       to_days(log_calc.expire_time) - to_days(CURRENT_DATE())                           as expire_day,
       if(to_days(log_calc.expire_time) > to_days(CURRENT_DATE()), '-1',
          if(to_days(log_calc.expire_time) < to_days(CURRENT_DATE()),
             concat('+', to_days(CURRENT_DATE()) - to_days(log_calc.expire_time)), '0')) as `status` #状态
from kyc_quota_change_log_v2 log
         left join contract on contract.id = log.contract_id
         left join contract_deal deal on contract.id = deal.contract_id
         left join (
    select log.id,
           if(
                       log.expire_time > if
                       (
                           log.overdue_start_time is null,
                           log.expire_time,
                           date_add(log.overdue_start_time, interval ifnull( if(log.contract_direction = 'P', kiql.p_account_period, kiql.s_account_period), 0) day)
                       ),
                       if(
                               log.overdue_start_time is null,
                               log.expire_time,
                               date_add(log.overdue_start_time, interval ifnull(if(log.contract_direction = 'P', kiql.p_account_period, kiql.s_account_period), 0) day)
                           ),
                       log.expire_time
               ) as expire_time
    from kyc_quota_change_log log
             left join kyc_info_quota_limit kiql on kiql.kyc_info_id = log.kyc_id
) log_calc on log_calc.id = log.id
where log.deleted = false and log.clear = false and quota_type = 'prompt'

