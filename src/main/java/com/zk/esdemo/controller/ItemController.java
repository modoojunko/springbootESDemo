package com.zk.esdemo.controller;

import com.zk.esdemo.entities.Item;
import com.zk.esdemo.service.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {
    @Autowired
    ItemServiceImp itemService;
    @GetMapping("/items")
    public List<Item> getAllItems(){
        return itemService.findByAll();
    }
    @GetMapping("/items/{id}")
    public Optional<Item> getItemById(@PathVariable Long id){
        return itemService.findById(id);
    }



}
