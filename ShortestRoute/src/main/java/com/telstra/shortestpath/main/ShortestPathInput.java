package com.telstra.shortestpath.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.telstra.shortestpath.main.model.Shortest;


public class ShortestPathInput {
	
	
	  public String cal(String number,String matrix,String origin) {

		    // Create adjacency matrix
		    int number_of_nodes;
		    ShortestRoute solver = null;
		    try
		    {
		        number_of_nodes = Integer.parseInt(number);
		        double[][] distanceMatrix = new double[number_of_nodes][number_of_nodes];
		        
		        String[] inputValues= matrix.split("\n");
		        
		      int inputValuesIncrement=0;
		        
		        for (int i = 0; i < number_of_nodes; i++)
		        {
		        	
		        	
		        	String[] inputValues1 = inputValues [inputValuesIncrement].split(" ") ;
		        	int input =0;
		            for (int j = 0; j < number_of_nodes; j++)
		            {
		            	distanceMatrix[i][j] = Double.parseDouble(inputValues1[input]);
		            	input++;
		            }
		            inputValuesIncrement++;
		        }
		       
		        int startNode = 0;
		        startNode = Integer.parseInt(origin);
		        // Run the solver
		         solver = new ShortestRoute(startNode,distanceMatrix);

		       
		    } catch (InputMismatchException inputMismatch)
		     {
		         System.out.println("Wrong Input format");
		     }
			return "Route: "+solver.getTour()+"\n"+"Distance: "+solver.getTourCost();
		  
		  }

}
