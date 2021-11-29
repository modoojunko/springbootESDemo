package com.zk.esdemo.controller;

import com.zk.esdemo.entities.Item;
import com.zk.esdemo.service.ItemServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = "接口案例")
@RestController
@RequestMapping(value = "/items", produces = "application/json;charset=UTF-8")
public class ItemController {
    @Autowired
    ItemServiceImp itemService;

    @ApiOperation("查询所有清单")
    @GetMapping()
    public List<Item> getAllItems() {
        return itemService.findByAll();
    }

    @ApiOperation("模糊查询标题")
    @GetMapping(value = "/search")
    public List<Item> getAllItems(@RequestParam(required = false) String title) {
        return itemService.findByTitleLike(title);
    }

    @ApiOperation("查询单个物品")
    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemService.findById(id);
    }


}
