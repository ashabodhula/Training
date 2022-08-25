package com.Training.productservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.Training.productservice.model.*;


public interface ProductRepository extends CrudRepository<Product, Integer>  {

}
