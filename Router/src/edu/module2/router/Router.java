package edu.module2.router;


public interface Router {
	
	Path getBestPath(Node[][] field, Node start, Node end);
	
	long getTime();

}
