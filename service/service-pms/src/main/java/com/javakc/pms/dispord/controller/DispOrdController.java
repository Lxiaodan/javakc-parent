package com.javakc.pms.dispord.controller;

import com.javakc.commonutils.api.APICODE;
import com.javakc.pms.dispord.entity.DispOrd;
import com.javakc.pms.dispord.service.DispOrdService;
import com.javakc.pms.dispord.vo.DispOrdQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 表现层实现类
 * @create 2020/11/2314:05
 */
@Api(tags = "调度指令控制器")
@RestController
@RequestMapping("/pms/dispord")
@CrossOrigin
public class DispOrdController {

    @Autowired
    private DispOrdService dispOrdService;

    @ApiOperation("查询所有调度指令库数据")
    @GetMapping
    public APICODE findAll(){
       List<DispOrd> list = dispOrdService.findAll();
       return APICODE.OK().data("itmes",list);
    }

    @ApiOperation("带条件的分页查询 - 调度指令库")
    @PostMapping("{pageNum}/{pageSize}")
    public APICODE findPageDispOrd(@RequestBody(required = false) DispOrdQuery dispOrdQuery, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        Page<DispOrd> page = dispOrdService.findPageDispOrd(dispOrdQuery,pageNum,pageSize);
        //当前页的数据集合
        List<DispOrd> list = page.getContent();
        //总条数
        long totalElements = page.getTotalElements();

        return APICODE.OK().data("total",totalElements).data("items",list);
    }


    @ApiOperation("新增 - 调度指令库")
    @PostMapping("createDispOrd")
    public APICODE createDispOrd(@RequestBody DispOrd dispOrd){
        dispOrdService.saveOrUpdate(dispOrd);
        return APICODE.OK();
    }

    @ApiOperation("根据调度指令库ID获取单条数据")
    @GetMapping("{dispOrdId}")
    public APICODE getById(@PathVariable("dispOrdId") int dispOrdId){
        DispOrd dispOrd = dispOrdService.getById(dispOrdId);
        return APICODE.OK().data("items",dispOrd);
    }

    @ApiOperation("修改 - 调度指令库")
    @PutMapping
    public APICODE updateDispOrd(@RequestBody DispOrd dispOrd){
       dispOrdService.saveOrUpdate(dispOrd);
       return APICODE.OK();
    }

    @ApiOperation("删除 - 调度指令库")
    @DeleteMapping("{dispOrdId}")
    public APICODE deleteDispOrd(@PathVariable("dispOrdId") int dispOrdId){
        dispOrdService.removeById(dispOrdId);
        return APICODE.OK();
    }
}
