package com.zk.esdemo.entities;

import com.zk.esdemo.EsDemoApplication;
import com.zk.esdemo.repos.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootTest(classes = EsDemoApplication.class)
class ItemTest {

    @Autowired
    private ElasticsearchRestTemplate template;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void addOne(){
        Item item = new Item();
        item.setId(new Random().nextLong());
        item.setContent("测试测试");
        item.setPrice(new Random().nextDouble());
        item.setTitle("elastic");
        item.setBrand("zk");
        itemRepository.save(item);
    }

    @Test
    public void findById(){
        Optional<Item> item2 = itemRepository.findById(1L);
        System.out.println(item2.toString());
    }
    @Test
    public void findByBrand(){
        List<Item> item2 = itemRepository.findByBrand("zk");
        for (Item item : item2) {
            System.out.println(item.toString());
        }
    }
    @Test
    public void findByTitleLike(){
        List<Item> item2 = itemRepository.findByTitleLike("es%");
        for (Item item : item2) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void findByAll(){
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

}