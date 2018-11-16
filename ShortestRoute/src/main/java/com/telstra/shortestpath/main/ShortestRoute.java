package com.telstra.shortestpath.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This file contains a recursive implementation of the TSP problem using 
 * dynamic programming. The main idea is that since we need to do all n!
 * permutations of nodes to find the optimal solution that caching the results 
 * of sub paths can improve performance. 
 */



public class ShortestRoute {
  
  private final int N;
  private final int START_NODE;
  private final int FINISHED_STATE;

  private double[][] distance;
  private double minTourCost = Double.POSITIVE_INFINITY;

  private List<Integer> tour = new ArrayList<>();
  private boolean ranSolver = false;

  public ShortestRoute(double[][] distance) {
    this(0, distance);
  }

  public ShortestRoute(int startNode, double[][] distance) {
    
    this.distance = distance;
    N = distance.length;
    START_NODE = startNode;
    
    // Validate inputs.
    if (N <= 2) throw new IllegalStateException("Solution will not work on 0, 1 or 2 nodes");
    if (N != distance[0].length) throw new IllegalArgumentException("Matrix must be square (N x N)");
    if (START_NODE < 0 || START_NODE >= N) throw new IllegalArgumentException("Starting node must be: 0 <= startNode < N");
    if (N > 32) throw new IllegalArgumentException("Matrix too large! This" +
                                                   "requires way too much computation for any modern home computer to handle");

    // The finished state is when the finished state mask has all bits are set to
    // one (meaning all the nodes have been visited).
    FINISHED_STATE = (1 << N) - 1;
  }

  // Returns the optimal tour for the traveling salesman problem.
  public List<Integer> getTour() {
    if (!ranSolver) solve();
    return tour;
  }

  // Returns the minimal tour cost.
  public double getTourCost() {
    if (!ranSolver) solve();
    return minTourCost;
  }

  public void solve() {

    // Run the solver    
    int state = 1 << START_NODE;
    //Declare visited array for caching already visited route[N][2^N]
    Double[][] visited = new Double[N][1 << N];
    Integer[][] prev = new Integer[N][1 << N];
    minTourCost = tsp(START_NODE, state, visited, prev);
    
    // Regenerate path
    int index = START_NODE;
    while (true) {
      tour.add(index);
      Integer nextIndex = prev[index][state];
      if (nextIndex == null) break;
      int nextState = state | (1 << nextIndex);
      state = nextState;
      index = nextIndex;
    }
    tour.add(START_NODE);
    ranSolver = true;
  }

  private double tsp(int i, int state, Double[][] visited, Integer[][] prev) {
    
    // Done this tour. Return cost of going back to start node.
    if (state == FINISHED_STATE) return distance[i][START_NODE];
    
    // Return cached answer if already computed.
    if (visited[i][state] != null) return visited[i][state];
    
    double minCost = Double.POSITIVE_INFINITY;
    int index = -1;
    for (int next = 0; next < N; next++) {
      
      // Skip if the next node has already been visited.
      if ((state & (1 << next)) != 0) continue;
      
      int nextState = state | (1 << next);
      double newCost = distance[i][next] + tsp(next, nextState, visited, prev);
      if (newCost < minCost) {
        minCost = newCost;
        index = next;
      }
    }
    
    prev[i][state] = index;
    return visited[i][state] = minCost;
  }

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
