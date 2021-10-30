package com.zk.esdemo.service;

import com.zk.esdemo.entities.Item;

import java.util.List;
import java.util.Optional;


public interface ItemService {
    Optional<Item> findById(Long id);
    //List<Item> findByAll();
}
