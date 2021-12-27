package main.program;

public class MergeProcess {

	public int[] mergeArrays(int[] arr1, int[] arr2) {
		int s1 = 0, s2 = 0, e1 = arr1.length, e2 = arr2.length, c = 0;
		int tmp[] = new int[e1 + e2];
		for (; s1 <= e1 && s2 <= e2;) {
			if (arr1[s1] <= arr2[s2]) {
				tmp[c++] = arr1[s1++];
			} else {
				tmp[c++] = arr2[s2++];
			}
		}
		for (; s1 <= e1;) {
			tmp[c++] = arr1[s1++];
		}
		for (; s2 <= e2;) {
			tmp[c++] = arr2[s2++];
		}
		return tmp;
	}
}