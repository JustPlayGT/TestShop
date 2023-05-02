package com.gt.test.TestShop.servises;

import com.gt.test.TestShop.models.TestOrder;
import com.gt.test.TestShop.repositories.TestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TestService {

    TestRepository repository;

    @Autowired
    public TestService(TestRepository repository) {
        this.repository = repository;
    }

    public List<TestOrder> index(){
    return repository.findAll();
    }

    public TestOrder show(int id){
      return repository.findById(id).get();
    }

    public void save(TestOrder testOrder){
        repository.save(testOrder);
    }

    public void delete(int id){
        repository.deleteById(id);
    }


}
