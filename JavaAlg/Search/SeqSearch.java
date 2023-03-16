package kr.ac.sejong.db.java_test.JavaAlg.Search;

public class SeqSearch {
	void find(int x[], int key) {
		for(int i=0; i<x.length; i++) {
			if(x[i] == key) {
				System.out.printf("%d은(는) x[%d]에 있습니다.", key, i);
				return;
			}
		}
		System.out.printf("값이 존재하지 않습니다.");
		
	}
}
