package com.telstra.shortestpath.main;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	
	
	  public static void main(String[] args) {

		    // Create adjacency matrix
		    int number_of_nodes;
		    Scanner scanner = null;
		    try
		    {
		        System.out.println("Enter the number of nodes in the graph");
		        scanner = new Scanner(System.in);
		        number_of_nodes = scanner.nextInt();
		        double[][] distanceMatrix = new double[number_of_nodes][number_of_nodes];
		        System.out.println("Enter the adjacency matrix");
		        for (int i = 0; i < number_of_nodes; i++)
		        {
		            for (int j = 0; j < number_of_nodes; j++)
		            {
		            	distanceMatrix[i][j] = scanner.nextInt();
		            }
		        }
		        for (int i = 0; i < number_of_nodes; i++)
		        {
		            for (int j = 0; j < number_of_nodes; j++)
		            {
		                if (distanceMatrix[i][j] == 1 && distanceMatrix[j][i] == 0)
		                {
		                	distanceMatrix[j][i] = 1;
		                }
		            }
		        }
		        System.out.println("Enter the origin city");
		        int startNode = 0;
		        startNode = scanner.nextInt();
		        // Run the solver
		        ShortestRoute solver = new ShortestRoute(startNode,distanceMatrix);

		        // Prints the optimal route
		        System.out.println("Tour: " + solver.getTour());

		        // Prints the optimal cost
		        System.out.println("Tour cost: " + solver.getTourCost());
		       
		    } catch (InputMismatchException inputMismatch)
		     {
		         System.out.println("Wrong Input format");
		     }
		    scanner.close();
		  
		  }

}
