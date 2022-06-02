package com.atguigu.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.atguigu.gulimall.product.entity.AttrEntity;
import com.atguigu.gulimall.product.service.AttrAttrgroupRelationService;
import com.atguigu.gulimall.product.service.AttrService;
import com.atguigu.gulimall.product.service.CategoryService;
import com.atguigu.gulimall.product.vo.AttrGroupRelationVo;
import com.atguigu.gulimall.product.vo.AttrGroupWithAttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.product.entity.AttrGroupEntity;
import com.atguigu.gulimall.product.service.AttrGroupService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 属性分组
 *
 * @author ch
 * @email sun@gmail.com
 * @date 2022-05-16 12:00:59
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    AttrService attrService;

    @Autowired
    AttrAttrgroupRelationService relationService;


    //product/attrgroup/225/withattr
    @GetMapping("/{catlogId}/withattr")
    public  R getAttrGroupWithAttrs(@PathVariable("catlogId") Long catlogId){
        //1.查出当前分类下所有分组
        //2.查出每个分组下的所有属性
        List<AttrGroupWithAttrVo> vos = attrGroupService.getAttrGroupWithAttrByCatelogId(catlogId);

        return R.ok().put("data",vos);
    }



    ///product/attrgroup/attr/relation
    @PostMapping("/attr/relation")
    public  R noattrRelationAttrList(@RequestBody List<AttrGroupRelationVo> vos){
        relationService.saveBatch(vos);

        return R.ok();
    }





    //product/attrgroup/1/noattr/relation
    @GetMapping("/{attrgroupId}/noattr/relation")
    public  R noattrRelationAttrList(@RequestParam Map<String,Object> params,
                                     @PathVariable("attrgroupId") Long attrgroupId){
        PageUtils page = attrService.getNoRelationAttr(params,attrgroupId);

        return R.ok().put("page",page);
    }


    ///product/attrgroup/attr/relation/delete
    @PostMapping("/attr/relation/delete")
    public R deleteRelation(@RequestBody AttrGroupRelationVo[] attrGroupRelationVo){
        attrService.deleteRelation(attrGroupRelationVo);
        return R.ok();
    }


    ///1/attr/relation
    @GetMapping("/{catelogId}/attr/relation")
    public R attrRelation(@PathVariable Long catelogId){
        List<AttrEntity> entity= attrService.getRelationAttr(catelogId);
        return R.ok().put("data", entity);
    }

    /**
     * 列表
     * @param  catelogId 0的话查所有
     */
    @RequestMapping("/list/{catelogId}")
    public R list(@RequestParam Map<String, Object> params,@PathVariable Long catelogId){
        //        PageUtils page = attrGroupService.queryPage(params);
        PageUtils page = attrGroupService.queryPage(params,catelogId);
        return R.ok().put("page", page);
    }




    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
//@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        // 用当前当前分类id查询完整路径并写入 attrGroup
        attrGroup.setCatelogPath(categoryService.findCateLogPath(attrGroup.getCatelogId()));
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
