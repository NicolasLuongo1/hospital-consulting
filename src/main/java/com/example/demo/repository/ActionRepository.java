package com.example.demo.repository;

import com.example.demo.entity.Action;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository  extends MongoRepository<Action,String> {

}