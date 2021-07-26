package com.mohsinkd786.java.spring.repo;

import com.mohsinkd786.java.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> findAll(){
        return mongoTemplate.findAll(User.class);
    }

    public List<User> findUsersByName(String name){
        // exact match
        //Query query = Query.query(Criteria.where("name").is(name));
        // like query
        Query query = new Query();
        Criteria criteria = Criteria.where("name").regex(".*"+name+".*");
        query.addCriteria(criteria);

        return mongoTemplate.find(query,User.class);
    }
}
