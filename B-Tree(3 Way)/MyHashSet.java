package org.dfpl.db.hash.m16011279;
import java.util.ArrayList;


// package 이름은 org.dfpl.db.hash.m학번 입니다. 
// 지키지 않을 시 반려합니다. 
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.dfpl.db.hash.m16011279.MyIterator;

public class MyHashSet implements Set<Integer> {

	// 너무 어려운 학생은 LinkedList 등으로 작성하셔도 됩니다.
	// 최대 3점을 받을 수 있습니다.
	// 멤버 변수는 hashTable 이외의 것을 사용하지 않습니다. (예: size)
	private MyThreeWayBTree[] hashTable;
	// 예: private LinkedList<Integer>[] hashTable;

	public MyHashSet() {
		// 해시테이블 배열 크기는 3로 고정합니다.
		// hash function은 key를 3로 나눈 값이며,
		// 충돌시 3-way B-Tree에 저장됩니다.
		
		hashTable = new MyThreeWayBTree[3];
		// hashTable 배열에 각각 B-Tree 생성
		for(int i=0; i<3; i++)
			hashTable[i] = new MyThreeWayBTree();
	}

	@Override
	public int size() {
		// 예제 코드로 수정해도 됩니다. 
		int size = 0;
		for (MyThreeWayBTree t : hashTable) {
			size += t.size();
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(this.size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean contains(Object o) {
		int bucketIndex = ((Integer)(o)).hashCode()%3;
		MyThreeWayBTree bucket = hashTable[bucketIndex];
		return bucket.contains(o);
	}

	@Override
	public boolean add(Integer e) {
		
		int bucketIndex = e.hashCode()%3;
		MyThreeWayBTree bucket = hashTable[bucketIndex];
		
		//hashTable에 e가 존재하는가?
		//중복 방지
		if(bucket.contains(e)) {
			return false;
		}
		
		bucket.add(e);
		return true;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator(hashTable);
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
