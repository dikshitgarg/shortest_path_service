package com.telstra.shortestpath.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.telstra.shortestpath.main.model.Shortest;


public class ShortestPathInput {
	
	
	  public String cal(String number,String matrix,String origin) {

		    // Create adjacency matrix
		    int number_of_nodes;
		   // Scanner scanner = null;
		    ShortestRoute solver = null;
		    try
		    {
		       // System.out.println("Enter the number of nodes in the graph");
		        //scanner = new Scanner(System.in);
		        number_of_nodes = Integer.parseInt(number);
		        double[][] distanceMatrix = new double[number_of_nodes][number_of_nodes];
		       // System.out.println("Enter the adjacency matrix");
		        
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
		        /*for (int i = 0; i < number_of_nodes; i++)
		        {
		            for (int j = 0; j < number_of_nodes; j++)
		            {
		                if (distanceMatrix[i][j] == 1 && distanceMatrix[j][i] == 0)
		                {
		                	distanceMatrix[j][i] = 1;
		                }
		            }
		        }*/
		      //  System.out.println("Enter the origin city");
		        int startNode = 0;
		        startNode = Integer.parseInt(origin);
		        // Run the solver
		         solver = new ShortestRoute(startNode,distanceMatrix);

		        // Prints the optimal route
		        //System.out.println("Tour: " + solver.getTour());

		        // Prints the optimal cost
		        //System.out.println("Tour cost: " + solver.getTourCost());
		       
		    } catch (InputMismatchException inputMismatch)
		     {
		         System.out.println("Wrong Input format");
		     }
		    //scanner.close();
			return "Route: "+solver.getTour()+"\n"+"Distance: "+solver.getTourCost();
		  
		  }

}
