package com.zljin.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.zljin.gulimall.common.valid.AddGroup;
import com.zljin.gulimall.common.valid.UpdateGroup;
import com.zljin.gulimall.common.valid.UpdateStatusGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zljin.gulimall.product.entity.BrandEntity;
import com.zljin.gulimall.product.service.BrandService;
import com.zljin.gulimall.common.utils.PageUtils;
import com.zljin.gulimall.common.utils.R;



/**
 * 品牌
 *
 * @author leonard
 * @email leoanrd_zou@163.com
 * @date 2024-08-14 11:49:24
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody @Validated(AddGroup.class) BrandEntity brand/*, BindingResult result*/){
        /*        if(result.hasErrors()){
            Map<String,String> map = new HashMap<>();
            result.getFieldErrors().forEach(t->{
                map.put(t.getField(),t.getDefaultMessage());
            });
            R.error(400,"提交数据不合法").put("data",map);
        }else {
            brandService.save(brand);
        }*/
		brandService.save(brand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@RequestBody @Validated(UpdateGroup.class) BrandEntity brand){
		brandService.updateById(brand);
        return R.ok();
    }

    @RequestMapping("/update/status")
    public R updateStatus(@RequestBody @Validated(UpdateStatusGroup.class) BrandEntity brand){
        brandService.updateById(brand);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
