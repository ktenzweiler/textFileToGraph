package graph;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Kyle Enzweiler
 *
 * The AdjacencyList Class extends the LinkedList.Class. It holds a Linked List
 * of integers. Each adjacency list will belong to a Vertex, the integers in the
 * List represent the vertices to which the the Vertex connects with a directed
 * edge.
 */
class AdjacencyList extends LinkedList<Integer> {

    //Adds an int that corresponds to the destination vertex_id
    public void setEdge(int destinationVertex) {

        //add the destination vertex to the list
        this.add(destinationVertex);

    }//end setEdge()

    /*
     This method returns a String that with the vertices to which it connects
     */
    public String print() {

        ListIterator iter = this.listIterator();
        StringBuilder strBuilder = new StringBuilder();

        while (iter.hasNext()) {

            //Iterate through the list and turn each value into a String. 
            strBuilder.append(iter.next().toString());
            strBuilder.append(" ");//append each value to strBuilder 
            //separated by a " "
        }

        //return a String representation of the vertices connected by an edge
        return strBuilder.toString();

    }//end print()

}//end AdjacencyList.Class
