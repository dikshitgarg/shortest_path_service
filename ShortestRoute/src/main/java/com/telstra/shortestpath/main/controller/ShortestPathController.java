package com.telstra.shortestpath.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.shortestpath.main.ShortestPathInput;
import com.telstra.shortestpath.main.model.Shortest;
import com.telstra.shortestpath.main.repository.ShortestPathServiceRepository;


@RestController
@RequestMapping("/v1")
public class ShortestPathController {
	ShortestPathInput shortestPathInput =new ShortestPathInput();
	
	@Autowired
	private ShortestPathServiceRepository pathServiceRepository;
	@Autowired
	MongoOperations mongoOperations;
	
	@RequestMapping(value="/shortest" ,method=RequestMethod.POST , produces = { "application/json" })
	public Shortest  shortest(@RequestBody Shortest shortest) {
		shortest.setResult(shortestPathInput.cal(shortest.getNumber(), shortest.getDistance(), shortest.getOrigin()));
		return shortest;
	}
	
	@RequestMapping(value="/save" ,method=RequestMethod.POST , produces = { "application/json" })
	public void  save(@RequestBody Shortest shortest) {
		pathServiceRepository.save(shortest);
	}
	
	@RequestMapping(value="/values" ,method=RequestMethod.GET , produces = { "application/json" })
	public List<Shortest>  getAllValues() {
		List<Shortest> valuesList = pathServiceRepository.findAll();
		return valuesList;
	}

}
