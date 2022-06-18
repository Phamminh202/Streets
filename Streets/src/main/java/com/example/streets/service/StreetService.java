package com.example.streets.service;

import com.example.streets.entity.Street;

import com.example.streets.repository.StreetRepository;
import com.example.streets.search.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*public Page<Street> findAll(FilterParameter param) {
        Specification<Street> specification = Specification.where(null);
        if (param.getKeyword() != null && param.getKeyword().length() > 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("keyword", SearchCriteriaOperator.JOIN, param.getKeyword());
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (param.getStatus() != 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("status", SearchCriteriaOperator.EQUALS, param.getStatus());
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (param.getDistrictId() != null) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("userId", SearchCriteriaOperator.EQUALS, param.getUserId());
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        return streetRepository.findAll(
                specification, PageRequest.of(param.getPage() - 1, param.getLimit()));
    }*/

}
