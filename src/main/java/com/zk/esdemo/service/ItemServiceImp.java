package com.zk.esdemo.service;

import com.zk.esdemo.entities.Item;
import com.zk.esdemo.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

   // @Override
    //public List<Item> findByAll() {
    //    return itemRepository.findAll();
    //es}
}
