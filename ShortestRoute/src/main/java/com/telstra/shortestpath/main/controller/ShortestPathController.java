package com.telstra.shortestpath.main.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.shortestpath.main.ShortestPathInput;
import com.telstra.shortestpath.main.model.Shortest;


@RestController
@RequestMapping("/v1")
public class ShortestPathController {
	ShortestPathInput shortestPathInput =new ShortestPathInput();
	@RequestMapping(value="/shortest" ,method=RequestMethod.POST , produces = { "application/json" })
	public Shortest  shortest(@RequestBody Shortest shortest) {
		System.out.println(shortest.getNumber());
		System.out.println(shortest.getDistance());
		System.out.println(shortest.getOrigin());
		shortest.setResult(shortestPathInput.cal(shortest.getNumber(), shortest.getDistance(), shortest.getOrigin()));
		
		
		return shortest;
	}

}
