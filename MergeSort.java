package assignment2;

public class MergeSort {

    private static int[] merge(int[] A1, int[] A2)
    {
        int[] result = new int[A1.length + A2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < A1.length && j < A2.length){
            if (A1[i] <= A2[j]){
                result[k++] = A1[i++];
            } else {
                result[k++] = A2[j++];
            }
        }

        while (i < A1.length){
            result[k++] = A1[i++];

        }

        while (j < A2.length){
            result[k++] = A2[j++];
        }

        return result;

    }

    public static int[] mergesort(int[] A)
    {
        if (A.length <= 1) {
            return A;
        }

        int mid = A.length / 2;

        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }

        int[] right = new int[A.length - mid];
        for (int i = mid; i < A.length; i++) {
            right[i - mid] = A[i];
        }

        int[] sortedLeft = mergesort(left);
        int[] sortedRight = mergesort(right);

        return merge(sortedLeft, sortedRight);
    }

    private static void print(int[] A)
    {
        for (int i=0; i<A.length; i++)
        {
            System.out.print(A[i] + ((i<A.length-1)?", ":""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(merge(new int[] {1,3,5,7,9}, new int[] {2,4,6,8}));
        print(mergesort(new int[] {5,2,8,1,3,9,7,4,6} ));
    }

}
