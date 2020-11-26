package com.javakc.pms.dispord.service;

import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import com.javakc.pms.dispord.dao.DispOrdDao;
import com.javakc.pms.dispord.entity.DispOrd;
import com.javakc.pms.dispord.vo.DispOrdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 带条件的分页查询 - 调度指令库
 * @description: 逻辑层实体类
 * @create 2020/11/2314:08
 */
@Service
public class DispOrdService extends BaseService<DispOrdDao,DispOrd> {
    @Autowired
    DispOrdDao dispOrdDao;

    public List<DispOrd> findAll(){
        List<DispOrd> list = dispOrdDao.findAll();
        return list;
    }

    public Page<DispOrd> findPageDispOrd (DispOrdQuery dispOrdQuery,int pageNum,int pageSize){
        SimpleSpecificationBuilder<DispOrd> simpleSpecificationBuilder = new SimpleSpecificationBuilder<>();
        if (!StringUtils.isEmpty(dispOrdQuery.getOrderName())){
            simpleSpecificationBuilder.and("orderName",":",dispOrdQuery.getOrderName());
        }
        if (!StringUtils.isEmpty(dispOrdQuery.getBeginDate())){
            simpleSpecificationBuilder.and("gmtCreate","ge",dispOrdQuery.getBeginDate());
        }
        if (!StringUtils.isEmpty(dispOrdQuery.getEndDate())){
            simpleSpecificationBuilder.and("gmtCreate","le",dispOrdQuery.getEndDate());
        }
        Page<DispOrd> page =dispOrdDao.findAll(simpleSpecificationBuilder.getSpecification(), PageRequest.of(pageNum-1,pageSize));
        return page;
    }
}
