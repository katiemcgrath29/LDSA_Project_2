package assignment2;

public class DivideAndConquer {

    public static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int fibNMinus1 = fibonacci(n - 1);
        int fibNMinus2 = fibonacci(n - 2);

        return fibNMinus1 + fibNMinus2;
    }

    public static int search(int[] A, int v) {
        return binarySearch(A,v,0,A.length - 1);
    }

    public static int binarySearch(int[] A, int v, int low, int high){
        if (low > high){
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (A[mid] == v){
            return mid;
        }
        else if (A[mid] < v){
            return binarySearch(A,v,mid+1,high);
        } else {
            return binarySearch(A,v,low,mid-1);
        }

    }

    public static void hanoi(int n, char A, char B, char C) {
        if (n == 1){
            System.out.println("Move disk 1 from " + A + " to " + C);
            return;
        }
        hanoi(n-1, A,C,B);
        System.out.println("Move disk " + n + " from " + A + " to " + C);
        hanoi(n-1, B,A,C);
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(fibonacci(i));
        }
        System.out.println();

        for (int i=0; i<10; i++) {
            System.out.println(search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, i));
        }
        System.out.println();


        hanoi(4, 'A', 'B', 'C');
    }
}
