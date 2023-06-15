package heap;

import java.util.Comparator;

public class GenericBinHeapMain {
	public static void main(String[] args) {
		Comparator<Integer> asc = new Comparator<Integer> () {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		
		Comparator<Integer> desc = new Comparator<Integer> () {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
			
		Integer[] items = {5, 6, 10, 4, 11};
		GenericBinHeap<Integer, Comparator<Integer>> heap = new GenericBinHeap<>(items, asc);
		
		heap.insert(2);
		
		System.out.println(heap);
		
		while (heap.size() > 0) {
			Integer n = heap.delTop();
			System.out.println(heap);
		}
	}
}