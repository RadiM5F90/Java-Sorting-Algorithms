import java.util.*;

// in the main method we create an instance of the heap
public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 8, 4, 1, 3, 2, 7, 6, 5, 9};

        Heap heap = new Heap(arr);

        // as long as there is an element (heap.getSize() > 0), call extractRoot() and print the element
        while(heap.getSize() > 0){
            System.out.print(heap.extractRoot() + " ");
        }
    }
}
