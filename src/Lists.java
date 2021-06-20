public class Lists {

	public Lists() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	/**
	 * structure of a node in the Singly Linked List
	 * */

	public class Node {
		Node next;
		int val;

		Node(int data) {
			this.val = data;
		}
	}

	public void run() {

		/*
		 * Node head = new Node(25); head = insertFront(head,14); head =
		 * insertFront(head,24); head = insertFront(head,34); head =
		 * insertFront(head,44); printList(head);
		 */

		Node head2 = new Node(1);
		head2 = insertRear(head2, 2);
		head2 = insertRear(head2, 3);
		head2 = insertRear(head2, 4);
		head2 = insertRear(head2, 5);
		head2 = insertRear(head2, 6);
		head2 = insertRear(head2, 7);
		head2 = insertRear(head2, 8);
		head2 = insertRear(head2, 9);
		head2 = insertRear(head2, 10);
		head2 = insertRear(head2, 11);
		head2 = insertRear(head2, 12);
		head2 = insertRear(head2, 13);
		head2 = insertRear(head2, 14);
		head2 = insertRear(head2, 15);
		head2 = insertRear(head2, 16);
		head2 = insertRear(head2, 17);
		head2 = insertRear(head2, 18);
		head2 = insertRear(head2, 19);
		head2 = insertRear(head2, 20);
		head2 = insertRear(head2, 21);
		head2 = insertRear(head2, 22);
		head2 = insertRear(head2, 23);
		head2 = insertRear(head2, 24);
		head2 = insertRear(head2, 25);
		head2 = insertRear(head2, 26);
		head2 = insertRear(head2, 27);
		head2 = insertRear(head2, 28);
		printList(head2);
		System.out.println();
		Node head1 = new Node(9);
		head1 = insertRear(head1, 1);
		head1 = insertRear(head1, 7);
		head1 = insertRear(head1, 3);
		//printList(head1);
		
		//Node result = add2Lists(head2,head1);
		//System.out.println("Testing");
		System.out.println();
	//	printList(result);
		segregateEvenOddNodes(head2);
		//kAtlReverse(head2,4);
		//System.out.println();
		//ReverseList(head2);
		
		printList(head2);
	}
	/***
	 * Function to add two LL
	 * */
	
	public Node add2Lists(Node l1,Node l2) {
		
		Node res = null;
		Node prev = null;
		
		int quotient = 0;
		int remainder = 0;
		l1 = ReverseList(l1);
		l2 = ReverseList(l2);
		while(l1 != null && l2 != null) {
			quotient = (l1.val + l2.val)/10;
			remainder = (l1.val + l2.val)%10;
			if(l1.next != null)
				l1.next.val += quotient;
			else
				l2.next.val += quotient;
			l1 = l1.next;l2 = l2.next;
			Node newNode = new Node(remainder);
			if(res == null)
				res = newNode;
			else 
				prev.next = newNode;
			
			prev = newNode;
		}
		//System.out.println("coming here + prev node " + prev.val);
		if(l1 != null) {
			//System.out.println("coming here + l1 node " + l1.val);
			while(l1 != null) {
				if(l1.val >= 10) { 
					quotient = (l1.val )/10;
					remainder = (l1.val)%10;
					if(l1.next != null)
						l1.next.val += quotient;
					Node newNode = new Node(remainder);
					prev.next = newNode;					
					prev = newNode;
					
					l1 = l1.next;
					
				}else {
					prev.next = l1;
					prev = l1;
					l1 = l1.next;
				}
			}
		}
		if(l2 != null) {
			while(l2 != null) {
				if(l2.val >= 10) {
					quotient = (l2.val )/10;
					remainder = (l2.val)%10;
					if(l2.next != null)
						l2.next.val += quotient;
					Node newNode = new Node(remainder);
					prev.next = newNode;					
					prev = newNode;					
					l2 = l2.next;
					
				}else {
					prev.next = l2;
					prev = l2;
					l2 = l2.next;
				}
			}
		}
		res = ReverseList(res);
		return res;
	}
	/**
	 * function to reverse a Linked List
	 * */
	public Node ReverseList(Node node) {
		if(node == null)
			return null;
		Node temp,cur = null;
		while(node != null) {
			temp = node;
			node = node.next;
			temp.next = cur;
			cur = temp;
		}
		return cur;
	}
	
	/**
	 * function to reverse a Linked List
	 * */
	public Node ReverseKNodes(Node node,int k) {
		if(node == null)
			return null;
		Node temp,cur = null;
		int count =1;
		while(count <=k && node != null) {
			temp = node;
			node = node.next;
			temp.next = cur;
			cur = temp;
			count++;
		}
		return cur;
	}

	/**
	 * function to Reverse the K alternate nodes
	 * */	
		
		public Node kAtlReverse(Node node,int k) {
		
			Node temp,cur= node,prev = null;
			int count = 1;
			if(k <=0)
				return null;
			
//			while(cur != null && count < k) {				
//				temp = cur;
//				cur = cur.next;
//				temp.next = prev;
//				prev = temp;
//				count++;
//			}
//			if(node.next != null) {
//				System.out.print("  node => " + node.val );
//				node.next = cur;
//			}
//			
//			count =0;
//			while(cur != null &&  count < k -1 ) {				
//				cur = cur.next;				
//				count++;
//			}
//			System.out.print("  prev => " + prev.val + " cur => " + cur.val);
//			if(cur.next != null )
//				cur.next = kAtlReverse(cur.next,k);
//			
//			return prev;
			
			while(cur !=null && count <=k) {
				prev = cur;
				cur = cur.next;
				count++;
			}
			temp = cur;
			count = 1;
			while(cur!= null && count <= k) {
				cur = cur.next;
				count++;
			}
			if(prev != null)
				prev.next = ReverseKNodes(temp,k);
			//cur = prev.next.next;
			count = 1;
			while(prev!= null && count <= k) {
				prev = prev.next;
				count++;
			}
			if(prev != null)
				prev.next = kAtlReverse(cur, k);
			return node;
		}

	/**
	 * function to insert the node at the rear end of the List
	 * */

	public Node insertRear(Node head, int val) {
		if (head == null)
			return null;

		Node newNode = new Node(val);
		Node cur = head;
		while (cur.next != null)
			cur = cur.next;

		cur.next = newNode;
		return head;
	}

	/**
	 * function to insert the node at the front of the List
	 * */

	public Node insertFront(Node head, int val) {
		if (head == null)
			return null;
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;

		return head;
	}

	/**
	 * print List
	 * */
	public void printList(Node head) {
		if (head == null)
			System.out.println("List is empty");
		else {
			while (head != null) {
				if (head.next == null)
					System.out.print(head.val);
				else
					System.out.print(head.val + "->");
				head = head.next;
			}
		}
	}

	/**
	 * function to segregate the even and odd nodes in the List
	 * */
	public void segregateEvenOddNodes(Node node) {
		if (node == null)
			return;
		Node prev = node;
		Node cur = node;
		Node head, temp;
		while (cur.next != null)
			cur = cur.next;
		head = cur;
		while (prev.next != head) {
			if ((prev.val % 2) != 0) {
				System.out.print(prev.val + "->");
				temp = prev;
				cur.next = temp;
				prev = prev.next;
				cur.next.next = null;
				cur = cur.next;
			} else {
				prev = prev.next;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Lists();
	}

}
