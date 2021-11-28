package com.zk.esdemo.entities;

import com.zk.esdemo.EsDemoApplication;
import com.zk.esdemo.repos.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes = EsDemoApplication.class)
class ItemTest {

    @Autowired
    private ElasticsearchRestTemplate template;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void createItemByNoArgs(){
        Long id = new Random().nextLong();
        Double price = new Random().nextDouble();
        Item item = new Item();
        item.setId(id);
        item.setContent("测试测试");
        item.setPrice(price);
        item.setTitle("elastic");
        item.setBrand("zk");
        //itemRepository.save(item);
        assertThat(item.getBrand(),is("zk"));
        assertThat(item.getContent(),is("测试测试"));
        assertThat(item.getTitle(),is("elastic"));
        assertThat(item.getId(),is(id));
        assertThat(item.getPrice(),is(price));
    }

    @Test
    public void createItemByAllArgs(){
        Long id = new Random().nextLong();
        Double price = new Random().nextDouble();
        Item item = new Item(id,
                "elasticsearch",
                "全参数构造函数",
                "zk",
                price);
        //itemRepository.save(item);
        assertThat(item.getBrand(),is("zk"));
        assertThat(item.getContent(),is("全参数构造函数"));
        assertThat(item.getTitle(),is("elasticsearch"));
        assertThat(item.getId(),is(id));
        assertThat(item.getPrice(),is(price));
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