
package com.telstra.shortestpath.main.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.telstra.shortestpath.main.model.Shortest;
@Repository
public interface ShortestPathServiceRepository extends MongoRepository<Shortest, String> {
	
	
}
