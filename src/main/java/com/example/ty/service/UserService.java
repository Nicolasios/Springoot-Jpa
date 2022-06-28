package com.example.ty.service;

import com.example.ty.entity.UserEntity;
import com.example.ty.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserService {
    @Resource
    private UserRepository userRepository;

    public Page<UserEntity> findAllPage(Map<String,Object> paramMap,int pageNum,int pageSize){
        Sort sort = Sort.by("id").descending();
        PageRequest pageable = PageRequest.of(pageNum, pageSize, sort);
        Integer number = paramMap.get("number") == null ? 0 : Integer.parseInt((String) paramMap.get("number")) ;
        String address = paramMap.get("address") == null ? "" : (String) paramMap.get("address");
        Specification<UserEntity> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Join<Object, Object> joinPart = root.join("partEntity", JoinType.INNER);
            if (!StringUtils.isEmpty(address)) {
                predicates.add(criteriaBuilder.like(joinPart.get("address"), "%" + address + "%"));
            }
            if(number!=0){
                predicates.add(criteriaBuilder.equal(joinPart.get("number"),  number));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        Page<UserEntity> all = userRepository.findAll(spec,pageable);
        return all;
    }

    public List<UserEntity> findAll(Map<String, Object> paramMap){
        log.info("paramMap:{}",paramMap);
        Integer number = paramMap.get("number") == null ? 0 : Integer.parseInt((String) paramMap.get("number")) ;
        String address = paramMap.get("address") == null ? "" : (String) paramMap.get("address");
        log.info("number:{}",number);
        log.info("address:{}",address);
        Specification<UserEntity> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Join<Object, Object> joinPart = root.join("partEntity", JoinType.INNER);
            if (!StringUtils.isEmpty(address)) {
                predicates.add(criteriaBuilder.like(joinPart.get("address"), "%" + address + "%"));
            }
            if(number!=0){
                predicates.add(criteriaBuilder.equal(joinPart.get("number"),  number));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        List<UserEntity> all = userRepository.findAll(spec);
        return all;
    }
}
