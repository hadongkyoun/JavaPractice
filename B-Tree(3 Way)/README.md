# Notice
3way B-Tree를 구현 했으나, Deletion 기능은 빠져있음.

---

## 주요한 기능 (Insert에 대한 간단한 설명)
3Way B-Tree의 각 Node의 데이터를 이렇게 추상화 해서 해결

* 해당 노드가 부모노드를 가리키는 [Node data type] parent;
* 해당 노드의 키들이 담긴 [Array List type] keyList;
* 해당 노드가 가지고 있는 Child가 담긴 [Node data type [] ] children;

Insertion에서 중요한 건 Split 과정.
keyList가 3-Way B-Tree라면 최대 2개까지 가능한데 세개가 되는 순간 Split 진행 ( violate )
- 노드의 key가 세개라면 자연스레 Children을 담은 List의 갯수도 네개가 됨 ( violate )

이러한 Logic 들로 ThreeWayBTree를 구현
