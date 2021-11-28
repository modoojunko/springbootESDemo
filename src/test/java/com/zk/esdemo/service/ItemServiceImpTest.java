package com.zk.esdemo.service;

import com.zk.esdemo.repos.ItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceImpTest {
    @Mock
    ItemRepository itemRepository;

    @Autowired
    ItemServiceImp itemServiceImp;

    @Test
    void findById() {
    }

    @Test
    void findByAll() {
    }
}