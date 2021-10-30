package com.zk.esdemo.repos;

import com.zk.esdemo.entities.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
    Optional<Item> findById(Long id);
    List<Item> findAll();
    List<Item> findByBrand(String brand);
    List<Item> findByTitleLike(String title);
}