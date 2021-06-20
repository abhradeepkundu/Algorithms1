package com.abhra.Graphs;

/**
 * http://www.geeksforgeeks.org/snake-ladder-problem-2/
 * 
 * Given a snake and ladder board, find the minimum number of dice throws required to reach the destination or last cell from source or 1st cell.
 *  Basically, the player has total control over outcome of dice throw and wants to find out minimum number of throws required to reach last cell.
 * */
public class SnakeAndladder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N=30;
		int[] moves = new int[N];
		for(int i : moves)
			moves[i] = -1;
		
		// Ladders
	    moves[2] = 21;
	    moves[4] = 7;
	    moves[10] = 25;
	    moves[19] = 28;
	 
	    // Snakes
	    moves[26] = 0;
	    moves[20] = 8;
	    moves[16] = 3;
	    moves[18] = 6;
	    
	    System.out.println(getMinimuMovesToReachEnd(moves,N));
	}

	public static class QueueEntry {
		int vertexNumber; 
		int distance; // distance of this vertex from source
		QueueEntry(int vert,int dist) {
			this.vertexNumber = vert;
			this.distance = dist;
		}
	}
	public static class Queue<T> {
		public void enqueue(QueueEntry ququeEntrty) {
			
		}
		public QueueEntry deQueue() {
			return null;
		}
		public boolean isQueueEmpty() {
			return false;
		}
	}
	
	Queue<QueueEntry> q = new Queue<QueueEntry>();
	private static int getMinimuMovesToReachEnd(int[] moves, int N) {
		for(int i=0;i<N-1;i++)
			moves[i] = -1; 
		boolean[] visited = new boolean[N];
		visited[0] = true;
		Queue<QueueEntry> q = new Queue<QueueEntry>();
		QueueEntry queueEntry = new QueueEntry(0,0);
		q.enqueue(queueEntry);
		QueueEntry qe = new QueueEntry(0, 0);
		while(!q.isQueueEmpty()) {
			qe = q.deQueue();
			int v = qe.vertexNumber;
			if(v == N-1) // pawn has moved to the last vertex
				break;
			
			for(int j=v+1;v<N;j++) {
				QueueEntry a = new QueueEntry(j,0);
				if(!visited[j]) {
					visited[j] = true;
					a.distance = qe.distance + 1;
					
					
					if(moves[j] != -1)
						a.vertexNumber = moves[j];
					else 
						a.vertexNumber = j;
					q.enqueue(a);
				}
			}
			
		}
		return qe.distance;	
		
	}

}
