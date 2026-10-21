
/*
* Time Analysis
* heapify() runs in O(log n) in the worst case
* buildHeap() runs in O(n) 
* extractRoot() runs in O(log n) per extraction
* The total time xomplexity is O(n log n)
*/

/* 
 * Possible Applications
 * When we want to know the task that carries the highest priority given a large number of things to do
 * Interval scheduling, when we have a lists of certain task with start and finish times and we want to do as many tasks as possible
 * Sorting a list of elements that needs and efficient sorting algorithm
*/


public class Heap {
    int arr[];
    int size;  // size of the heap

    // constructor, takes in an array
    // when you call this constructor, it is going to build a heap from the array with the buildHeap() method
    public Heap(int arr[]){
        this.arr = arr;
        this.size = arr.length;

        // converting the array into a heap
        buildHeap();
    }

    // iterates over all the elements
    /*
     * How does it build a heap?
     * It takes the last known leaf node, and then from there it backtracks to the root node
     * this.size / 2 - 1 is the last known leaf node
     * Inside the for-loop, the heapify() method is called for every node
     */
    void buildHeap(){
        for(int i = this.size / 2 - 1; i >= 0; i--){
            heapify(i);
        }
    }

    // Finds the max element between eny given node and its left and right children
    // Whatever child is the greatest, replaces it with the root
    void heapify(int root_index){
        int child = root_index * 2 + 1;
        int max_index = root_index;

        // finding which child is bigger, so finding the max value
        // left child
        if(child < size) {
            if(arr[child] > arr[root_index]) {
                max_index = child;
            }
        }

        // right child
        if(child + 1 < size){
            if(arr[child + 1] > arr[max_index]) {
                max_index = child + 1;
            }
        }
        // swapping the nodes
        swap(arr, root_index, max_index);

        // checking if the root index was changed
        // In case it was changed, we have to apply the heapify algo to the location that was swapped with the root index
        if(root_index != max_index){
            heapify(max_index);   // Applying heapify to the max_index because this is the element that was swapped with the root index
        }
    }

    void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    int getSize(){
        return size;
    }

    // This method extracts the max element and will return it
    // Everytime it extracts the max element, it replaces it with the last element in the array or the heap, and then it applies
    // heapify to the root node
    int extractRoot(){
        int max = arr[0];

        // replacing max with the last element
        arr[0] = arr[--size]; // --size because it replaces the element and also decreases the size of the heap
        heapify(0); // heapify on the first index
        return max; // return the max element
    }
}

// This is a min heap, it sorts the elements in a decreasing orderd
// To sort the elements in an increasing order, use a max heap
