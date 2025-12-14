package org.ms.productmicroservice.repositories;

import org.ms.productmicroservice.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends MongoRepository<Product, String>
{}
