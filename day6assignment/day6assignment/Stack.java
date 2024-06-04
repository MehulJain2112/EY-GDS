package com.ey.day6assignment;

public class Stack {
	private Contact[] stackArray;
	private int top;
	private int maxSize;
	
	public Stack(int size) {
		super();
		this.stackArray = new Contact[size];
		this.top = -1;
		this.maxSize = size;
	}
	
	public void push(Contact contact) throws Exception {
		if(isFull()) {
			throw new Exception ("Stack is full. Cannot Push a new Contact...");
		}
		if(!contact.isValid()) {
			throw new Exception ("Invalid Contact Details...");
		}
		stackArray[++top] = contact;
	}
	
	public Contact pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is Empty. Cannot pop a new Contact...");
		}
		return stackArray[top--];
	}
	
	public boolean isEmpty() {
		return(top==-1);
	}
	
	public boolean isFull() {
		return(top==maxSize-1);
	}
}
