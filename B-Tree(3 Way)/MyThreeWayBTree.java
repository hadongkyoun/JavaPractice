package org.dfpl.db.hash.m16011279;
//package 이름은 org.dfpl.db.hash.m학번 입니다. 

//지키지 않을 시 반려합니다. 

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.SortedSet;

@SuppressWarnings("unused")
public class MyThreeWayBTree implements NavigableSet<Integer> {

	// Data Abstraction은 예시일 뿐 자유롭게 B-Tree의 범주 안에서 어느정도 수정가능

	private MyThreeWayBTreeNode root;

	MyThreeWayBTree(){
		//초기 상태
		this.root = null;
	}
	
	//Iterator에서 root를 가져오기 위한 함수
	public MyThreeWayBTreeNode getRoot() {
		return this.root;
	}
	
	@Override
	public int size() {	//수정 필요 할듯
		if(this.isEmpty())
			return 0;
		
		int[] cnt = new int[1];
		//전위 순회로 돌면서 숫자 세아리기
		cntTraversal(this.root, cnt);
		return cnt[0];
	}
	public void cntTraversal(MyThreeWayBTreeNode node, int[] cnt) {
		if(node.isLeaf()) {
			cnt[0] += node.keyList.size();
			return;
		}
		
		cnt[0] += node.keyList.size();
		
		for(int i=0; i<node.children.size(); i++) {
			cntTraversal(node.children.get(i), cnt);
		}
		
		
	}

	@Override
	public boolean isEmpty() {
		if(this.root == null)
			//root가 없으면 Tree는 Empty
			return true;
		
		return false;
	}
	
	@Override
	public boolean contains(Object o) {
		if (this.root == null)
			return false;
		MyThreeWayBTreeNode T = this.root;
		int v = ((Integer)(o)).intValue();
		// Leaf Node가 나올때 까지	(전체 순회 할 필요 X)
		while (!T.isLeaf()) {
			//key의 값에따라서 child로 이동하기 전에 검사	(findT에서 이 부분만 추가된 로직)
			for(int i=0; i<T.keyList.size(); i++)
				if(T.keyList.get(i) == v)
					return true;
			
			// key가 1개일때 ( middle child는 존재X )
			if (T.keyList.size() == 1) {
				if (T.keyList.get(0) > v)
					T = T.children.get(0);
				else
					T = T.children.get(1);
			}
			// key가 2개일때
			// Middle Child가 존재하니까 RC는 인덱스 1 증가 ( List.add(1, Node) 로 중앙으로 삽입할 예정 )
			else if (T.keyList.size() == 2) {
				if (T.keyList.get(0) > v)
					T = T.children.get(0);
				else if (T.keyList.get(1) > v)
					T = T.children.get(1);
				else
					T = T.children.get(2);
			}
		}
		//마지막 리프노드 까지 검사
		for(int i=0; i<T.keyList.size(); i++)
			if(T.keyList.get(i) == v)
				return true;
		return false;
		
	}
	
	//삽입 되어질 LeafNode를 찾는 함수
	public MyThreeWayBTreeNode findT(MyThreeWayBTreeNode T, int v) {
		//Leaf Node가 나올때 까지 ( 삽입 될 T 찾기 )
		while(!T.isLeaf()) {	//자식이 없으면 LeafNode
			//key가 1개일때 ( middle child는 존재X )
			if(T.keyList.size() == 1) {
				if(T.keyList.get(0) > v)
					T = T.children.get(0);		
				else
					T = T.children.get(1);
			}
			//key가 2개일때
			//Middle Child가 존재하니까 RC는 인덱스 1 증가 ( List.add(1, Node) 로 중앙으로 삽입할 예정 )
			else if(T.keyList.size() == 2){
				if(T.keyList.get(0) > v)
					T = T.children.get(0);
				else if(T.keyList.get(1) > v) 
						T = T.children.get(1);
				else
					T = T.children.get(2);	
			}
		}
		return T;
	}
	
	public void rebalance(MyThreeWayBTreeNode ReNode) {
		//max-key Property를 어긴 경우 ( T 노드부터 시작 )
		while(ReNode != null && ReNode.keyList.size() > 2) {
			
			//ReNode Split 시작
			
			//Split 하고 기존의 정보들을 연결하고 추가 할 새로운 베이스
			MyThreeWayBTreeNode parentReNode = ReNode.parent;
			ReNode.parent = null;
			MyThreeWayBTreeNode middle = new MyThreeWayBTreeNode();
			middle.keyList.add(ReNode.keyList.get(1));	//ReNode의 middle Up
			
			MyThreeWayBTreeNode left = new MyThreeWayBTreeNode();
			left.keyList.add(ReNode.keyList.get(0));	//ReNode의 Left Key 추가
			MyThreeWayBTreeNode right = new MyThreeWayBTreeNode();
			right.keyList.add(ReNode.keyList.get(2)); // ReNode의 Right Key 추가

			if (parentReNode == null) {
				
				//Left, Middle, right 연결
				//첫 Split인 경우 && 아닌 경우 둘다 동일하게 작업
				left.parent = middle;
				right.parent = middle;
				middle.makeChildSpace();
				middle.children.add(left);
				middle.children.add(right);
				
				//첫 Split이 아닌 경우에 본래 ReNode의 자식들을 연결 해주는 추가 작업 필요
				if (!ReNode.isLeaf()) {
					// key가 세개면 children을 현재 4개를 가지고 있다는 소리다
					// 3Way BTree 이므로 이를 Split 해준다

					// [!] key가 세개니까 현재 child 개수는 4개다. (LC, MLC, MRC, RC)

					// left의 왼쪽 children에 Split 되어야 할 노드의 왼쪽 child(LC)를 추가한다
					left.makeChildSpace();
					left.children.add(ReNode.children.get(0));
					ReNode.children.get(0).parent = left;
					// left의 오른쪽 children에 Split 되어야 할 노드의 중앙child의 왼쪽(MLC)을 추가한다
					left.children.add(ReNode.children.get(1));
					ReNode.children.get(1).parent = left;
					// right의 왼쪽 children에 Split 되어야 할 노드의 중앙 child의 오른쪽(MRC) child를 추가한다
					right.makeChildSpace();
					right.children.add(ReNode.children.get(2));
					ReNode.children.get(2).parent = right;
					// right의 오른쪽 children에 Split 되어야 할 노드의 오른쪽(RC)을 추가한다
					right.children.add(ReNode.children.get(3));
					ReNode.children.get(3).parent = right;

				}
				
				//parentNode가 null이면 root Node
				//middle을 새로 생성해 줬기 때문에 이 작업 필수
				this.root = middle;
			}

			else {
				if (ReNode.isLeaf()) {
					// middle을 부모노드 key에 추가 ( bottom up )
					parentReNode.keyList.add(ReNode.keyList.get(1));
					// 앞서 생성한 middle은 필요 없다
					middle = null;
					
					// ReNode가 부모노드의 오른쪽 자식인 상태에서 Overflow가 일어났는지
					// 			부모노드의 왼쪽 자식인 상태에서 Overflow가 일어 났는지 확인
					
					
					// 		우선 부모노드의 children 개수가 몇개인지 확인하는게 중요
					// 		children ArrayList의 인덱스 착오가 없게끔 하기 위해서임
					// 		children의 개수가 2개일땐 인덱스 0이 LC 인덱스 1이 RC
					// 		children의 개수가 3개일땐 인덱스 0이 LC 인덱스 1이 MC 인덱스 2가 RC
					// 		children의 개수가 4개일땐(OverFlow 상황) (...) 인덱스 1이 MLC 인덱스 2가 MRC 인덱스 3이 RC(구현 필요 X)
					
					
					// parentReNode children get(0) => LC
					// parentReNode children get(1) => RC
					if (parentReNode.children.size() == 2) {
						
						//	Split 되어야 할 ReNode가 부모노드의 오른쪽 자식일때
						if(parentReNode.children.get(1).equals(ReNode)) {
							
							//기존에 연결 된 ReNode 삭제 (올바른 갱신을 위함)
							parentReNode.children.remove(ReNode);
							
							parentReNode.children.add(left);	//parentNode의 MC가 됨
							left.parent = parentReNode;
							
							parentReNode.children.add(right);	//parentNode의 RC가 됨
							right.parent = parentReNode;
						}
						
						//	Split 되어야 할 ReNode가 부모노드의 왼쪽 자식일때
						else if(parentReNode.children.get(0).equals(ReNode)) {
							
							//기존에 연결 된 ReNode 삭제 (올바른 갱신을 위함)
							parentReNode.children.remove(ReNode);

							
							parentReNode.children.add(0,right);	//parentNode의 MC
							right.parent = parentReNode;
							//분리된 left를 부모노드 children ArrayList 맨 앞에 추가 (인덱스 유지)
							parentReNode.children.add(0,left);		//parentNode의 LC
							left.parent = parentReNode;
						}
					}
					
					// parentReNode children get(0) => LC
					//parentReNode children get(1) => MC
					// parentReNode children get(2) => RC
					else if(parentReNode.children.size() == 3) {
						//	Split 되어야 할 ReNode가 부모노드의 오른쪽 자식일때
						if(parentReNode.children.get(2).equals(ReNode)) {
							
							//기존에 연결 된 ReNode 삭제 (올바른 갱신을 위함)
							parentReNode.children.remove(ReNode);
							
							parentReNode.children.add(left);	//parentNode의 MRC가 됨
							left.parent = parentReNode;
							
							parentReNode.children.add(right);	//parentNode의 RC가 됨
							right.parent = parentReNode;
						}
						
						//	Split 되어야 할 ReNode가 부모노드의 왼쪽 자식일때
						else if(parentReNode.children.get(0).equals(ReNode)) {
							
							//기존에 연결 된 ReNode 삭제 (올바른 갱신을 위함)
							parentReNode.children.remove(ReNode);

							parentReNode.children.add(0, right);	//parentNode의 MLC
							right.parent = parentReNode;
							//분리된 left를 부모노드 children ArrayList 맨 앞에 추가 (인덱스 유지)
							parentReNode.children.add(0, left);		//parentNode의 LC
							left.parent = parentReNode;
							
						}
					}
				}

				// 내부노드라면 여기서 더 추가 작업 밑에 자식들을 가져와야 함
				if (!ReNode.isLeaf()) {
						left.children.add(ReNode.children.get(0));
						ReNode.children.get(0).parent = left;
						// left의 오른쪽 children에 Split 되어야 할 노드의 중앙child의 왼쪽(MLC)을 추가한다
						left.children.add(ReNode.children.get(1));
						ReNode.children.get(1).parent = left;
						// right의 왼쪽 children에 Split 되어야 할 노드의 중앙 child의 오른쪽(MRC) child를 추가한다
						right.children.add(ReNode.children.get(2));
						ReNode.children.get(2).parent = right;
						// right의 오른쪽 children에 Split 되어야 할 노드의 오른쪽(RC)을 추가한다
						right.children.add(ReNode.children.get(3));
						ReNode.children.get(3).parent = right;
				}

			}	
			
			ReNode = parentReNode;

		}
	}

	@Override
	public boolean add(Integer e) {
		//빈 테이블 일때
		if(this.isEmpty()) {
			this.root = new MyThreeWayBTreeNode();
			root.keyList.add(e);
			return true;
		}
		
		
		//삽입 할 T 노드 찾기
		MyThreeWayBTreeNode T = findT(this.root, e.intValue());
		T.keyList.add(e);
		
		//max-key Property를 어긴 경우 ( T 노드부터 시작 )
		if(T.keyList.size()>2)
			rebalance(T);
		
		
		//MyThreeWayBTreeNode에 add 하기 전 MyHashSet add 함수에서 이미 contains를 확인 했기 때문에 무조건 true 반환
		return true;
		
	}

	public MyThreeWayBTreeNode lowestNode() {
		MyThreeWayBTreeNode lo = this.root;
		while(!lo.isLeaf()) {
			lo = lo.children.get(0);
		}
		
		return lo;
	}
	//구현 끝
	
	@Override
	public Iterator<Integer> iterator() {
		
		return  null;
	}
	
	//미구현~~~ 
	
	
	@Override
	public Comparator<? super Integer> comparator() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public Integer lower(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer floor(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer ceiling(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer higher(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<Integer> descendingSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<Integer> subSet(Integer fromElement, boolean fromInclusive, Integer toElement,
			boolean toInclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<Integer> headSet(Integer toElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<Integer> tailSet(Integer fromElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Integer> headSet(Integer toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Integer> tailSet(Integer fromElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer last() {
		// TODO Auto-generated method stub
		return null;
	}

}
