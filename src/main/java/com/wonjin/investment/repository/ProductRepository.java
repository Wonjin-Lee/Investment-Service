package com.wonjin.investment.repository;

import com.wonjin.investment.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
