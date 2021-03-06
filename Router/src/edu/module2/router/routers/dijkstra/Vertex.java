package edu.module2.router.routers.dijkstra;

import edu.module2.router.Node;

public class Vertex {
  final private String id;
  final private Node node;
  
  
  public Vertex(String id, Node node) {
    this.id = id;
    this.node = node;
  }
  public String getId() {
    return id;
  }

  public Node getNode() {
    return node;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vertex other = (Vertex) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return node.toString();
  }
  
} 