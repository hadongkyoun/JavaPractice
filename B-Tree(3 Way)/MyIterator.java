package org.dfpl.db.hash.m16011279;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyIterator implements Iterator<Integer> {

	private MyThreeWayBTree[] table;
	private int currentIndex;
	private ArrayList<Integer> ascOrder;
	
	public MyIterator(MyThreeWayBTree[] table) {
		this.table = table;
		this.currentIndex = 0;
		this.ascOrder = new ArrayList<Integer>();
		for(int i=0; i<table.length; i++) {
			myInOrder(table[i].getRoot());
		}
	}
	
	public void myInOrder(MyThreeWayBTreeNode root) {
		if(root.isLeaf()) {
			for(int i=0; i<root.keyList.size(); i++)
				ascOrder.add(root.keyList.get(i));
			return;
		}
		
		myInOrder(root.children.get(0));
		ascOrder.add(root.keyList.get(0));
		
		if(root.children.size() == 2) {
			myInOrder(root.children.get(1));
		}
		//MC가 존재하는 경우
		else if(root.children.size() == 3) {
			myInOrder(root.children.get(1));
			

			ascOrder.add(root.keyList.get(1));
			myInOrder(root.children.get(2));
		}
		
	}
	
	@Override
	public boolean hasNext() {
		try{
			int trial = ascOrder.get(currentIndex); //시도
			return true;
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
	}

	@Override
	public Integer next() {
		try{
			return ascOrder.get(currentIndex++); //시도
		}catch(IndexOutOfBoundsException e) {
			throw new NoSuchElementException();
		}
	}
	
}

