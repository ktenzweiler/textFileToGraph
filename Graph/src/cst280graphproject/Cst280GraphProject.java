package cst280graphproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Kyle Enzweiler
 *
 * This application does:
 *
 * 1.Define structures for adjacency lists and for an array of vertices. 1.
 * Defines an Array Object, vertexArray, to hold Objects of type Vertex.Class.
 * The Vertex.Class Objects have an attribute of type AdjacencyList.Class to
 * hold a LinkedList of the Vertex.Class Objects that this.vertex is connected
 * to by a directed edge.////////////////////////////////////////////////////
 * ///////////////////////////////////////////////////////////////////////////
 * 2.Initializes vertexArray with Vertex.Class Objects with -1 set for the
 * vertex_id field and the other fields are null./////////////////////////////
 * ////////////////////////////////////////////////////////////////////////////
 * 3.Reads graph.txt and holds info about the vertices: ///////////////////////
 * //-the vertex id, out-degree, adjacency list, assign 1 to the rank field.///
 * ///////////////////////////////////////////////////////////////////////////
 * 4.Outputs information about the graph using the format defined in the slides
 */
public class Cst280GraphProject {

    //indices for the vertex_id and the outDegree values in the lineArray
    private static final int VERTEX_ID_INDEX = 0;
    private static final int OUT_DEGREE_INDEX = 1;

    /*
     at index 2 of lineArray lies the third value of each line of the .txt file.
     This value represents the first vertex that is connected via directed edge*/
    private static final int EDGE_INDEX = 2;

    private static final double RANK = 1.00;//HW instruction 3.

    private static final String FILE_NAME = "graph.txt";
    private static final File GRAPH_FILE = new File(FILE_NAME);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //the destinationVertex is an integer that represents the vertex the
        //edge is connecting to. The vertex_id is the vertex id that 
        //corresponds to the vertexArray index. The outDegree corresponds to
        //the number of out-bound edges from the vertex
        int destinationVertex, vertex_id, outDegree;

        String line;//holds each line from the .txt file
        String[] lineArray;//holds the values from line after line is split 

        //adjList belongs to each vertex and holds the vertex_id's that the 
        //vertex connects to
        AdjacencyList adjList;

        Vertex vertex;//holds a Vertex to store in the vertexArray

        //initialize the vertexArray with vertices that have -1 as an index id
        Vertex[] vertexArray = new Vertex[200];
        for (int i = 0; i < vertexArray.length; i++) {

            /*when a Vertex is created w/out any parameters, the index_id
             attribute is initialized with -1 and the rest of the attributes
             are initialized with null*/
            vertexArray[i] = new Vertex();
        }

        //try to open the graph.txt file, read it, and display the graph in
        //the correct format
        try {
            //Open the graph.txt file and scan it with a Scanner Object
            Scanner scan = new Scanner(GRAPH_FILE);

            //while there is still more lines on the .txt file to be read
            while (scan.hasNextLine()) {

                /*
                 Store each line on the .txt file the variable line, then split
                 line into an array that is stored in lineArray.;
                 */
                line = scan.nextLine();
                lineArray = line.split(" ");//split line into a String Array

                /*the vertex_id will be the first value read from the line in
                 in the .txt file*/
                vertex_id = Integer.parseInt(lineArray[VERTEX_ID_INDEX]);

                //the outDegree is the second value in the line from .txt file
                outDegree = Integer.parseInt(lineArray[OUT_DEGREE_INDEX]);

                //create a new AdjacencyList and store it in adjList.
                adjList = new AdjacencyList();

                /*This for loop starts with i = 2, which is the third value in 
                 the .txt file line*/
                for (int i = EDGE_INDEX; i < lineArray.length; i++) {

                    //destination that the current vertex connects to
                    destinationVertex = Integer.parseInt(lineArray[i]);
                    adjList.setEdge(destinationVertex);//set the directed edge
                }//end for{}

                /*
                 make a new Vertex with the its id, outdegree, rank, and 
                 AdjacencyList */
                vertex = new Vertex(vertex_id, outDegree, RANK, adjList);

                /*
                 put vertex in the vertexArray. The vertex_id value is equal
                 to the index of the vertexArray */
                vertexArray[vertex_id] = vertex;//put vertex in the vertexArray

            }//end while(scan.hasNextLine())

            scan.close();// close the Scanner Object safely
        }//end of try{}
        catch (FileNotFoundException | NumberFormatException e) {

            System.out.println("either the file was not found or the file"
                    + "contains non-numeric values");

        }//end of catch{}

        /*
         Traverse through vertexArray and if the vertex_id != -1, then
         print the output info        
         */
        for (Vertex vert : vertexArray) {
            if (vert.vertex_id != -1) {
                System.out.println(vert.print());
            }
        }//end for{}

    }//end Main
}//end Cst280GraphProject
