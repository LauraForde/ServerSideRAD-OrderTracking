package com.sales.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.sales.models.Product;

@Repository
public interface ProductInter extends CrudRepository<Product, Long>{

}
