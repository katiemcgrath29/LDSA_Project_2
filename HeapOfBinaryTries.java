package assignment2;

public class HeapOfBinaryTries {
    private BinaryTrie[] A;
    private int heapsize;

    private void heapify(int i)
    {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < heapsize && A[left].compare(A[smallest])){
            smallest = left;
        }


        if (right < heapsize && A[right].compare(A[smallest])){
            smallest = right;
        }


        if (smallest != i) {
            BinaryTrie temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;

            heapify(smallest);
        }
    }

    public HeapOfBinaryTries(BinaryTrie[] A)
    {

        this.A = A;
        this.heapsize = A.length;

        for (int i = heapsize / 2 -1; i >= 0; i--) {
            heapify(i);
        }
    }

    public BinaryTrie extractMin()
    {

        if (heapsize <= 0){
            return null;
        }

        BinaryTrie min = A[0];

        A[0] = A[heapsize - 1];

        heapsize--;

        heapify(0);
        return min;
    }

    public void insert(BinaryTrie x) {
        if (heapsize == A.length) {
            BinaryTrie[] newA = new BinaryTrie[A.length * 2];
            System.arraycopy(A, 0, newA, 0, A.length);
            A = newA;
        }

        A[heapsize] = x;
        int i = heapsize;
        heapsize++;

        while (i > 0 && A[(i-1) / 2].compare(A[i])) {
            BinaryTrie temp = A[i];
            A[i] = A[(i-1) / 2];
            A[(i-1) / 2] = temp;

            i = (i-1) / 2;
        }
    }

    public int size()
    {
        return heapsize;
    }
}
