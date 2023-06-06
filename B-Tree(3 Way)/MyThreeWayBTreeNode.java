package org.dfpl.db.hash.m16011279;

import java.util.ArrayList;
//package �̸��� org.dfpl.db.hash.m�й� �Դϴ�. 
//��Ű�� ���� �� �ݷ��մϴ�. 
import java.util.List;

@SuppressWarnings("unused")
public class MyThreeWayBTreeNode {

	// Data Abstraction�� ������ �� �����Ӱ� B-Tree�� ���� �ȿ��� ������� ��������
	
	/*
	 * �ڹ��� Ŭ���� ĸ��ȭ ������ ������ private�� ����ؼ� get �޼���� ��� ���°� ������ �ڵ� ��ü�� �ʹ� �����ϰ� ������� �����
	 * private ����
	 */
	
	MyThreeWayBTreeNode parent;
	List<Integer> keyList;
	
	List<MyThreeWayBTreeNode> children;
	
	//��� ����
	MyThreeWayBTreeNode(){ 
		this.parent = null;
		this.keyList = new ArrayList<Integer>();
		this.children = null;
		/*	children�� ������ 4�� �ϴ� ������
		 * 	LeafNode���� overflow�� ���� �θ� ���� middle up�� ���ִµ�
		 * 	�θ��忡�� ���� overflow�� �Ͼ�ٸ�
		 * 	�θ����� Ű�� �����̸�, Leaf Node���� ���� ���� Ű Ȥ�� ū Ű��
		 * 	���� ���� �Ѿ�� �ϹǷ� logical �ϰ� �翬�� child�� 4�� �����
		 * 	��ġ�� 3 Way BTree�̹Ƿ� child 4���� �߾� 2�� �κ���
		 * 	�и��ϴ� �Լ��� ����� ���� children�� ������ 4���� �ߴ�
		 * 
		 * 	����, �̷��� ���·��ϸ� ���������� BTree�� ����ϴ´�� �ڵ� ������ �����ϸ�
		 * 	���� �پ��� ���̽��� �ϳ��� �Լ��� General�ϰ� ���� �����ϴ�
		 * 	
		 * 	null�� �ʱ�ȭ �����ν� Middle Child�� children[1], children[2]
		 * 	�� �� �ϳ��� Node�� ���� ��ų ���̰� �׷����ν� children ������ ����ؼ� ������ �����ϴ�
		 * 	3WayBTree�� ǥ����
		 */
	}
	
	//Leaf Node ���� Ȯ��
	boolean isLeaf() {
		if(this.children == null)
			return true;
		return false;
	}
	
	void makeChildSpace() {
		this.children = new ArrayList<MyThreeWayBTreeNode>();
	}
		
}
