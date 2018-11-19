package com.telstra.shortestpath.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.telstra.shortestpath.main.ShortestRoute;

public class ShortestRouteTest {
	ShortestRoute solver;
	@Before
    public void setUp() throws Exception {
		int no_of_nodes = 5;
	    double[][] distanceMatrix = new double[no_of_nodes][no_of_nodes];
	    for (double[] row : distanceMatrix) java.util.Arrays.fill(row, 10000);
	    distanceMatrix[0][1] = 12;
	    distanceMatrix[0][2] = 10;
	    distanceMatrix[0][3] = 19;
	    distanceMatrix[0][4] = 8;
		
		distanceMatrix[1][0] = 12;
	    distanceMatrix[1][2] = 3;
	    distanceMatrix[1][3] = 7;
	    distanceMatrix[1][4] = 2;
		
		distanceMatrix[2][0] = 10;
	    distanceMatrix[2][1] = 3;
	    distanceMatrix[2][3] = 6;
	    distanceMatrix[2][4] = 20;
		
		distanceMatrix[3][0] = 19;
	    distanceMatrix[3][1] = 7;
	    distanceMatrix[3][2] = 6;
	    distanceMatrix[3][4] = 4;
		
	    distanceMatrix[4][0] = 8;
	    distanceMatrix[4][1] = 2;
	    distanceMatrix[4][2] = 20;
	    distanceMatrix[4][3] = 4;

	    int startNode = 0;
	    solver = new ShortestRoute(startNode,distanceMatrix);
	}

	@Test
	public void test() {
    
		    //System.out.println("Tour: " + solver.getTour());

		    // Prints the optimal cost
		    //System.out.println("Tour cost: " + solver.getTourCost());
		    assertEquals(32.0, solver.getTourCost(),0.01);
		
		
	}

}
