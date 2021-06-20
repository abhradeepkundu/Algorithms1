import java.util.ArrayList;


public class Graphs {

	public Graphs() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	public static class List {		
		int data;
		List next;
	}
	public static class Node {
		String color = "white";
		int data;
		List adjList;
		Node(int val) {
			this.data = val;
		}
	}
	private void run() {
		// TODO Auto-generated method stub
		 int gr[][] = {
				 {0,1,1,1},
		         {1,0,0,1},
		         {1,0,0,1},	         
		         {1,1,1,0},
		         {1,0,1,0}
		         };
		 //System.out.println(gr[0][4]);
		 createGraph(gr);
	}

	private ArrayList<Node> createGraph(int[][] gr) {
		
		ArrayList<Node>  a = new ArrayList<Node>();
		/*Node one = new Node(0);
		Node two = new Node(1);
		Node three = new Node(2);
		Node four = new Node(3);*/
		a.add(new Node(0));
		a.add(new Node(1));
		a.add(new Node(2));
		a.add(new Node(3));
		a.add(new Node(4));
		int[] list;
		Node u = null;
		System.out.println("arrayList's size => " + a.size() + " graph Length => " + gr.length);
		for(int i=0;i<a.size();++i) {
			try {
				u = a.get(i);
				list = getNeighbours(gr,u.data); // get Neighbours of u
				printArray(list);
				BuildChain(u,list);
				printList(u,u.adjList);
			}catch(IndexOutOfBoundsException e) {
				e.printStackTrace();
			}				
		}
		return a;
	}
	public void printList(Node u,List l) {
		while( l != null && l.data != 0) {
			System.out.print(u.data +"::"+ l.data + "-> " + "   ");
			l = l.next;
		}
		System.out.println();
	}
	private void BuildChain(Node u, int[] list) {
		// TODO Auto-generated method stub

		List head = null;				
			for(int j = 0 ; j <  list.length;  ++j) {	
				if (list[j] != 0) {
					List node = new List();
					node.data = list[j];
					
					if (u.adjList == null)
						u.adjList = node;
					else {
						head = u.adjList;
						while (head.next != null)
							head = head.next;
						head.next = node;
					}
				}
			}
	}

	private int[] getNeighbours(int[][] gr, int u) {
		// TODO Auto-generated method stub
		
		int[] l = new int[gr.length];
		for(int i=0;i<gr[0].length;++i) {			
			if(gr[u][i] == 1)  {
				System.out.println("["+u+"]" + "[" +i +"]" + " : " + "1");
				l[i] = i+1;
			}
		}
		return l;
	}
	private void printArray(int[] a) {
		// TODO Auto-generated method stub		
		for(int i = 0 ; i< a.length; ++i) {
			if(a[i] != 0)
				System.out.print(a[i] + "->");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Graphs();
	}

}
