package com.example.demo.repository;

import com.example.demo.entity.Disease;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends MongoRepository<Disease, String> {
}