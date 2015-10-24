package graph;

/**
 *
 * @author Kyle Enzweiler
 * 
 * The Vertex Class represents a Vertex of the graph. It has a vertex_id that 
 * is unique and is equal to the vertexArray index that holds the Vertex. 
 * The outDegree is equal to the number of outbound edges from this Vertex.
 * The AdjacencyList holds a list of the vertices to which this vertex 
 * connects to.
 * 
 * Rank is equal to 1.00 as per hw instructions.
 */
class Vertex {

    int vertex_id, outDegree;
    double rank;
    AdjacencyList adjList;

    /*
    A no-arg constructor will initialize the vertex_id with -1 and the rest
    of the attributes will be null
    */
    public Vertex() {
        vertex_id = -1;
        
    }

    /*
    This constructor will initialize the vertex_id, outDegree, rank, and 
    adjacency list with the values passed in the parameters.
    */
    Vertex(int id, int outDeg, double rank, AdjacencyList adjList) {

        vertex_id = id;
        outDegree = outDeg;
        this.rank = rank;
        this.adjList = adjList;

    }

    /*
    Returns the information about this vertex. Its vertex_id,
    rank, out-degree, and the vertices to which it is connected.
    */
    public String print() {

        
        String str = "Vertex: " + vertex_id + ", Rank: " + rank 
                + ", out-degree: " + outDegree + "\nEdges from " + vertex_id 
                + " to: " + adjList.print() + "\n";
        
        return str;
    }//end print()

}//end Vertex.Class
