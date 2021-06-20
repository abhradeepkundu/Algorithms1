package com.abhra.Design;

import java.util.HashMap;

public class LRUCaching {

	/**
	 * http://www.geeksforgeeks.org/implement-lru-cache/
	 * @param args
	 */
	public static class QueueNode {
		int pageNumber;
		QueueNode prev;
		QueueNode next;
	}
	public static class Queue {
		QueueNode front;
		QueueNode rear;
		int count;
		int totalFrames;
		Queue(int maxQSize) {
			this.totalFrames = maxQSize;
		}
	}
	static HashMap<Integer,QueueNode> map = new HashMap<Integer,QueueNode>();
	
	public static void main(String[] args) {
		Queue queue = new Queue(10);
		ReferencePage(queue,map,1);	
	}

	private static void ReferencePage(Queue queue,HashMap<Integer, QueueNode> map, int pageNumber) {
		QueueNode requestedPage = map.get(pageNumber);
		// if page is not in memory, then put in the memory and make an entry in hash
		if(requestedPage == null)
			enqueue(queue,map,pageNumber);
		else if(queue.front != requestedPage) {
			// page is there in memory, but not the front one
			// remove the node from its place and put it in the front of the queue
			requestedPage.prev.next = requestedPage.next;
			if(requestedPage.next != null)
				requestedPage.next.prev = requestedPage.prev;
			
			
			// if the requested page is rear node
			if(requestedPage == queue.rear) {
				queue.rear = requestedPage.prev;
				queue.rear.next = requestedPage.next; // i.e assign null
			}
			requestedPage.next = queue.front;
			requestedPage.prev = null;
			
			queue.front.prev = requestedPage;
			queue.front = requestedPage;
		}
	}

	private static void enqueue(Queue queue, HashMap<Integer, QueueNode> map,int pageNumber) {
		if(isQueueFull(queue)) {
			// remove page from hash and dequeue queueNode from rear end
			map.remove(pageNumber);
			dequeue(queue);
		}
		QueueNode reqPage = new QueueNode();
		reqPage.pageNumber = pageNumber;
		if(isQueueEmpty(queue)) {
			queue.front = queue.rear = reqPage;
		}else {
			queue.front.prev = reqPage;
			queue.front = reqPage;
		}
		queue.count++;
		map.put(pageNumber, reqPage);
	}

	private static void dequeue(Queue queue) {
		if(isQueueEmpty(queue))
			return;
		if(queue.front == queue.rear) {
			queue.front = queue.rear = null;
			queue.count--;
			return;
		}
		
		queue.rear.prev.next = null;
		queue.rear = queue.rear.prev;
		queue.count--;
	}

	private static boolean isQueueEmpty(Queue queue) {
		return queue.rear == null;
	}

	private static boolean isQueueFull(Queue queue) {
		return queue.count == queue.totalFrames;
	}

}
