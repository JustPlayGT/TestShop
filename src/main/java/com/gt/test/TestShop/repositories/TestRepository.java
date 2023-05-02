package com.gt.test.TestShop.repositories;

import com.gt.test.TestShop.models.TestOrder;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends ListCrudRepository<TestOrder,Integer> {
}
