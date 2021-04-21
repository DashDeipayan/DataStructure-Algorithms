import java.util.*;

public class MinHeapConstruction {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeapConstruction(List<Integer> array) {
        heap = buildHeap(array);
    }

    private List<Integer> buildHeap(List<Integer> array) {
        int parentIdx = (array.size() - 2) / 2;
        for (int i = parentIdx; i >= 0; i--) {
            heapifyDown(i, array.size() - 1, array);
        }
        return array;
    }

    private void heapifyDown(int i, int end, List<Integer> heap) {
        int childLeftIdx = 2 * i + 1;
        while (childLeftIdx <= end) {
            int childRightIdx;
            if (i * 2 + 2 <= end) {
                childRightIdx = i * 2 + 2;
            } else {
                childRightIdx = -1;
            }
            int swapIdx;
            if (childRightIdx != -1 && heap.get(childRightIdx) < heap.get(childLeftIdx)) {
                swapIdx = childRightIdx;
            } else {
                swapIdx = childLeftIdx;
            }
            if (heap.get(swapIdx) < heap.get(i)) {
                swap(i, swapIdx, heap);
                i = swapIdx;
                childLeftIdx = i * 2 + 1;
            } else
                return;
        }
    }

    private void heapifyUp(int i, List<Integer> heap) {
        int parentIdx = (i - 1) / 2;
        while (i > 0 && heap.get(i) < heap.get(parentIdx)) {
            swap(i, parentIdx, heap);
            i = parentIdx;
            parentIdx = (i - 1) / 2;
        }
    }

    public int getRoot() {
        return heap.get(0);
    }

    public int removeFromHeap() {
        swap(0, heap.size() - 1, heap);
        int removedValue = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapifyDown(0, heap.size() - 1, heap);
        return removedValue;
    }

    public void remove() {
        System.out.println(removeFromHeap());
    }

    public void insertInHeap(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1, heap);
    }

    private void swap(int a, int b, List<Integer> heap) {
        Integer temp = heap.get(b);
        heap.set(b, heap.get(a));
        heap.set(a, temp);
    }

    public void printHeap() {
        System.out.println(heap);
    }

    static class MinHeap {
        public static void main(String[] args) {
            ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(18, 5, 4, 2, 1, 16, 7, 99, 12));

            MinHeapConstruction heap = new MinHeapConstruction(array);

            heap.printHeap();

            heap.insertInHeap(10);
            heap.insertInHeap(3);

            heap.printHeap();

            heap.remove();

            heap.printHeap();
        }
    }
}