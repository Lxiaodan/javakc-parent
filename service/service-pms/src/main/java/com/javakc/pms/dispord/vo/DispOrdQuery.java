package com.javakc.pms.dispord.vo;

import lombok.Data;

/**
 * @description: 封装查询条件 - 调度指令库
 * @create 2020/11/249:46
 */
@Data
public class DispOrdQuery {
    private String orderName;
    private String beginDate;
    private String endDate;
}
