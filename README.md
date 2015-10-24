# textFileToGraph

1.Defines an Array Object, vertexArray, to hold Objects of type Vertex.Class.
  The Vertex.Class Objects have an attribute of type AdjacencyList.Class to
  hold a LinkedList of the Vertex.Class Objects that this.vertex is connected
  to by a directed edge.
  
 2.Initializes vertexArray with Vertex.Class Objects with -1 set for the
  vertex_id field and the other fields are null.
  
 3.Reads graph.txt and holds info about the vertices: 
    -the vertex id, out-degree, adjacency list, assign 1 to the rank field
  
 4.Outputs information about the graph using a readable format
