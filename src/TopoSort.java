/* 
 * Oscar Hedblad
 * PID: o3415424
 * COP3503 - TopoPath.java
 * 
 * DESCRIPTION: Program that reads in file(s) and determines whether an arbitrary directed 
 * graph has a valid topological sort in which some vertex, in this case, X, comes before 
 * another vertex, Y. 
 * */

//Import necessaries
import java.io.*;
import java.util.*;

public class TopoSort {

	// Declare adjacency matrix
	boolean [][] matrix2D;

	// Constructor opens file named filename and reads the graph it contains
	// into an adjacency matrix
	public TopoSort(String filename) throws FileNotFoundException{

		// Declaring Scanner and read from filename
		Scanner input = new Scanner(new File(filename));

		// Declaration of variables. Reads in the number of nodes.
		int nodes = input.nextInt();
		int neighbour;

		// Creates 2D true-false matrix [nodes] x [nodes]
		matrix2D = new boolean[nodes][nodes];
		
		// Fills in matrix and reads in the amount of nodes that are a neighbouring node.
		for(int i = 0; i < nodes; i++){
			neighbour = input.nextInt();
			// Fill in matrix
			while(neighbour > 0){
				matrix2D[i][input.nextInt() - 1] = true;
				neighbour--;
			}
		}
	}
	
	/* Dr. Szumlanski's code found on Webcourses follows below. I used a large portion of 
	Toposort.java */
	public boolean hasTopoSort(int x, int y){

		int [] incoming = new int[matrix2D.length];
		int cnt = 0;
		// Declare two variables for spotting X & Y.
		int spotX = 0;
		int spotY = 0;

		// Count the number of incoming edges incident to each vertex. For sparse
		// graphs, this could be made more efficient by using an adjacency list.
		for (int i = 0; i < matrix2D.length; i++){
			for (int j = 0; j < matrix2D.length; j++){
				incoming[j] += (matrix2D[i][j] ? 1 : 0);
			}
		}

		Queue<Integer> q = new ArrayDeque<Integer>();

		// Any vertex with zero incoming edges is ready to be visited, so add it to
		// the queue.
		for (int i = 0; i < matrix2D.length; i++){
			if (incoming[i] == 0){
				q.add(i);
			}
		}

		while (!q.isEmpty())
		{
			// Pull a vertex out of the queue and add it to the topological sort.
			int node = q.remove();
			//System.out.println(node);

			//If Y is spotted, mark it as observed.
			if(node == y - 1){
				spotY = 1;
			}
			// If X is spotted, mark it as observed.
			if(node == x - 1){
				spotX = 1;
			}
			// If order of nodes matters and Y comes before X, break out of while-loop.
			if((q.peek() == null) && spotY == 1 && spotX == 0){
				break;
			}
	
			// Count the number of unique vertices we see.
			++cnt;

			// All vertices we can reach via an edge from the current vertex should
			// have their incoming edge counts decremented. If one of these hits
			// zero, add it to the queue, as it's ready to be included in our
			// topological sort.
			for (int i = 0; i < matrix2D.length; i++)
				if (matrix2D[node][i] && --incoming[i] == 0)
					q.add(i);
		}
		// If Y has an edge going to X, it means Y is mandatory to come before X.
		if(matrix2D[y-1][x-1] == true){
			return false;
		}

		// If we pass out of the loop without including each vertex in our
		// topological sort, we must have a cycle in the graph.
		if (cnt != matrix2D.length){
			return false;
		}
		//System.out.println("Error: Graph contains a cycle!");
		return true;
	}

	// Difficulty rating method. Another quite conceptually challenging assignment!
	public static double difficultyRating(){
		return 4.5;
	}
	// Number of hours spent on assignment
	public static double hoursSpent(){
		return 5.1;
	}

}
