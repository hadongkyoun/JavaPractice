package org.dfpl.db.hash.m16011279;
import java.util.ArrayList;


// package �̸��� org.dfpl.db.hash.m�й� �Դϴ�. 
// ��Ű�� ���� �� �ݷ��մϴ�. 
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.dfpl.db.hash.m16011279.MyIterator;

public class MyHashSet implements Set<Integer> {

	// �ʹ� ����� �л��� LinkedList ������ �ۼ��ϼŵ� �˴ϴ�.
	// �ִ� 3���� ���� �� �ֽ��ϴ�.
	// ��� ������ hashTable �̿��� ���� ������� �ʽ��ϴ�. (��: size)
	private MyThreeWayBTree[] hashTable;
	// ��: private LinkedList<Integer>[] hashTable;

	public MyHashSet() {
		// �ؽ����̺� �迭 ũ��� 3�� �����մϴ�.
		// hash function�� key�� 3�� ���� ���̸�,
		// �浹�� 3-way B-Tree�� ����˴ϴ�.
		
		hashTable = new MyThreeWayBTree[3];
		// hashTable �迭�� ���� B-Tree ����
		for(int i=0; i<3; i++)
			hashTable[i] = new MyThreeWayBTree();
	}

	@Override
	public int size() {
		// ���� �ڵ�� �����ص� �˴ϴ�. 
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
		
		//hashTable�� e�� �����ϴ°�?
		//�ߺ� ����
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
