package com.zljin.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zljin.gulimall.ware.entity.WareEntity;
import com.zljin.gulimall.ware.service.WareService;
import com.zljin.gulimall.common.utils.PageUtils;
import com.zljin.gulimall.common.utils.R;



/**
 * 仓库信息
 *
 * @author leonard
 * @email leoanrd_zou@163.com
 * @date 2024-08-15 21:11:20
 */
@RestController
@RequestMapping("ware/ware")
public class WareController {
    @Autowired
    private WareService wareService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:ware:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wareService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:ware:info")
    public R info(@PathVariable("id") Long id){
		WareEntity ware = wareService.getById(id);

        return R.ok().put("ware", ware);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:ware:save")
    public R save(@RequestBody WareEntity ware){
		wareService.save(ware);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:ware:update")
    public R update(@RequestBody WareEntity ware){
		wareService.updateById(ware);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:ware:delete")
    public R delete(@RequestBody Long[] ids){
		wareService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
