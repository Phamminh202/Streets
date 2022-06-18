package com.example.streets.service;

import com.example.streets.entity.Street;
import com.example.streets.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;

    public Iterable<Street> findAll(){
        return streetRepository.findAll();
    }
    public Street save(Street street){
        return streetRepository.save(street);
    }


    public Optional<Street> findById(String id){
        return streetRepository.findById(id);
    }

    /*public Page<Street> findByName(String param) {
        Specification<Street> specification = Specification.where(null);
        SearchCriteria searchCriteria = new SearchCriteria("keyword", SearchCriteriaOperator.JOIN, param.getKeyword());
        OrderSpecification filter = new OrderSpecification(searchCriteria);
        specification = specification.and(filter);
        return orderRepository.findAll(specification, PageRequest.of(param.getPage() - 1, param.getLimit()));
    }*/

}
