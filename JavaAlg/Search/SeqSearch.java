package kr.ac.sejong.db.java_test.JavaAlg.Search;

public class SeqSearch {
	void find(int x[], int key) {
		for(int i=0; i<x.length; i++) {
			if(x[i] == key) {
				System.out.printf("%d��(��) x[%d]�� �ֽ��ϴ�.", key, i);
				return;
			}
		}
		System.out.printf("���� �������� �ʽ��ϴ�.");
		
	}
}
