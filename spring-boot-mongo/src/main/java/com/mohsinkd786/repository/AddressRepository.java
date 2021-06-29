package com.mohsinkd786.repository;

import com.mohsinkd786.dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Address> findAddresses(){
        getAggregatedAddresses();
        return mongoTemplate.findAll(Address.class);
    }

    public Address createAddress(Address address){
        return mongoTemplate.save(address);
    }
    public List<Address> getAggregatedAddresses(){
//        Query query = new Query();
//        query.fields().include("city").exclude("_id");
//        List<Address> addresses = mongoTemplate.find(query,Address.class);
//        return addresses;

        Criteria criteria = new Criteria("city");
        criteria.in("BLR");

        MatchOperation filterByCity = Aggregation.match(criteria);
        SortOperation sortByCity = Aggregation.sort(Sort.by(Sort.Direction.DESC,"city"));
        GroupOperation groupOperation = Aggregation.group("city");

        Aggregation aggregation = Aggregation.newAggregation(groupOperation,filterByCity,sortByCity);

        AggregationResults<Address> results = mongoTemplate.aggregate(aggregation,"address",Address.class);
        return results.getMappedResults();
    }
}
