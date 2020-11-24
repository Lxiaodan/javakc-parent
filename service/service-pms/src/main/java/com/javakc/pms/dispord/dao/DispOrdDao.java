package com.javakc.pms.dispord.dao;

import com.javakc.commonutils.jpa.base.dao.BaseDao;
import com.javakc.pms.dispord.entity.DispOrd;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: 数据层接口
 * @create 2020/11/2314:07
 */
public interface DispOrdDao extends BaseDao<DispOrd,String> {
}
