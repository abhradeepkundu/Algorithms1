package com.abhra.Graphs;

public class KnightShortestPath {

	private static final int MAX_NODES = 64;
	private static final int MAX_ROWS = 8;
	
	KnightShortestPath() throws Exception {
		run();
	}

	private void run() throws Exception {
		int x1 = 5;int y1 = 3;int x2 = 7; int y2 = 7;
		findPath(x1,y1,x2,y2);
	}

	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new KnightShortestPath();		
	}
	
	public static class Node {
		String color;
		int parent;
		int distance;
		
		Node(String color,int parent,int dist) {
			this.color = color;
			this.parent = parent;
			this.distance = dist;
		}
	}

	Node[][] knightMoves = new Node[MAX_NODES][MAX_NODES];
	private  void findPath(int x1, int y1, int x2, int y2) throws Exception {
		for(int i=0;i<MAX_NODES;i++)
			for(int j=0;j<MAX_NODES;j++)
				knightMoves[i][j] = new  Node("white",0,Integer.MAX_VALUE);
		
		for(int i=0;i<MAX_ROWS;i++)
			for(int j=0;j<MAX_ROWS;j++)
				populateKnightMoves(i,j);
		
		int sourceVertex = (y1 * MAX_ROWS) + x1;
		int destVertex = (y2 * MAX_ROWS) + x2;
		
		BFS(sourceVertex);
		
		System.out.println("Shortest path : " + getPath(sourceVertex,destVertex));
	}

	private int getPath(int sourceVertex,int destVertex) {
		if(storage[destVertex].distance == 0)
			return -1;
		
		while(storage[destVertex].parent != sourceVertex) {
			destVertex = storage[destVertex].parent;
			System.out.println("destVertex : " + destVertex);
		}
		System.out.print("Source Vertex : " + sourceVertex);
		System.out.println();
		return storage[destVertex].distance;
	}

	Node[] storage = new Node[MAX_NODES];
	
	private void BFS(int sourceVertex) throws Exception {
	
		for(int i=0;i<MAX_NODES;i++)
			storage[i] = new Node("white",-1,0);
		
		//storage[sourceVertex].parent = 0;
		int u = sourceVertex;
		enqueue(u);
		while(!isQueueEmpty()) {
			 u = dequeue();
			storage[u].color = "gray";
			knightMoves[u][u].parent = 0;
			for(int i=0;i<MAX_NODES;i++) {
				if(knightMoves[u][i].distance == 1 ) {
					if(storage[i].color.equalsIgnoreCase("white")) {
						storage[i].color = "gray";
						storage[i].parent = u;
						storage[i].distance = storage[u].distance + 1;
						enqueue(i);
					}
				}
			}
		}
		storage[u].color = "Black";
	}

	int[] queue = new int[MAX_NODES];
	int f = 0, r = -1;
	private int dequeue() throws Exception {
		if(isQueueEmpty()) {
			throw new Exception("Queu is empty");
		}
		int u = queue[f++];
		return u;
	}

	private boolean isQueueEmpty() {
		if(f>r)
			return true;
		return false;
	}

	private void enqueue(int u) throws Exception {
		if(isQueueFull()) {
			throw new Exception("Queue is full");
		}
		queue[++r] = u;
			
	}

	private boolean isQueueFull() {
		if(r>=queue.length)
			return true;
		return false;
	}

	private void populateKnightMoves(int x, int y) {
		int xPlusOne = x+1;
		int xMinusOne = x-1;
		int xPlusTwo = x+2;
		int xMinusTwo = x-2;
		
		int yPlusOne = y+1;
		int yMinusOne = y-1;
		int yPlusTwo = y+2;
		int yMinusTwo = y-2;
		
		int currentNode = y * MAX_ROWS + x;
		knightMoves[currentNode][currentNode].distance = 0;
		int adjacentVertex;
		
		if(xPlusOne < MAX_ROWS && yPlusTwo < MAX_ROWS) {
			adjacentVertex =  yPlusTwo * MAX_ROWS + xPlusOne;
			knightMoves[currentNode][adjacentVertex].distance = 1;
		}
		
		if(xMinusOne >=0  && yPlusTwo < MAX_ROWS) {
			adjacentVertex =  yPlusTwo * MAX_ROWS + xMinusOne;
			knightMoves[currentNode][adjacentVertex].distance = 1;
		}
		
		if(xMinusOne >=0  && yMinusTwo >=0) {
			adjacentVertex =  yMinusTwo * MAX_ROWS + xMinusOne;
			knightMoves[currentNode][adjacentVertex].distance = 1;
		}
		
		if(xPlusOne < MAX_ROWS  && yMinusTwo >=0) {
			adjacentVertex =  yMinusTwo * MAX_ROWS + xPlusOne;
			knightMoves[currentNode][adjacentVertex].distance = 1;
		}
		
		if(yPlusOne < MAX_ROWS && xMinusTwo >=0 ) {
			adjacentVertex =  yPlusOne * MAX_ROWS + xMinusTwo;
			knightMoves[currentNode][adjacentVertex].distance = 1;
		}
		
		if(yPlusOne < MAX_ROWS && xPlusTwo < MAX_ROWS ) {
			adjacentVertex =  yPlusOne * MAX_ROWS + xPlusTwo;
			knightMoves[currentNode][adjacentVertex].distance = 1;
		}
		
		if(yMinusOne >=0  && xPlusTwo < MAX_ROWS ) {
			adjacentVertex =  yMinusOne * MAX_ROWS + xPlusTwo;
			knightMoves[currentNode][adjacentVertex].distance = 1;
		}
		
		if(yMinusOne >=0  && xMinusTwo >=0 ) {
			adjacentVertex =  yMinusOne * MAX_ROWS + xMinusTwo;
			knightMoves[currentNode][adjacentVertex].distance = 1;
		}
		return;
	}

}
