package leetcode.simple;

import java.util.Arrays;

public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        Arrays.stream(new MyTest().sort(new int[]{4, 3, 2, 1, 6, 5, 5, 6, 9})).forEach((it) -> {
            System.out.println(it);
        });
    }

    public int[] sort(int[] arr) {
        toHeap(arr, arr.length);

        int range = arr.length;
        while(range>0){
            swap(arr,0,range-1);
            range--;
            toHeap(arr,range);
        }

        return arr;
    }

    /**
     * 再写一遍堆
     * @param arr
     * @param size
     * https://www.bilibili.com/video/BV1Kr4y1j71u/?spm_id_from=333.788&vd_source=f0bef1126b5187474df4a4be5f9c13df
     */
    private void toHeap(int[] arr, int size) {
        int nodeIdx = size / 2 - 1;//size比idx大1，所以这样是对的，不然应该是(idx_child-1)/2=idx_parent

        while (nodeIdx >= 0) {
            adjustHeap(arr, nodeIdx, size);//size是边界，因为不一定是整个数组。
            nodeIdx--;
        }

    }

    private void adjustHeap(int[] arr, int nodeIdx, int size) {

        while (nodeIdx * 2 + 1 < size) {//有子孩子的话
            int leftIdx = nodeIdx * 2 + 1;
            int rightIdx = nodeIdx * 2 + 2;
            int maxChildIdx = leftIdx;
            if(rightIdx<size && arr[rightIdx]>arr[leftIdx]){
                maxChildIdx = rightIdx;
            }

            //compare with root and swap if root is small, 建立大顶堆。
            if(arr[nodeIdx]>=arr[maxChildIdx])return;

            //else , need swap
            swap(arr,nodeIdx,maxChildIdx);

            nodeIdx = maxChildIdx;//adjust child if it's a root node as well.
        }

    }


    public int[] sortHeap(int[] arr) {

        //堆化
        heapify(arr, arr.length);

        //排序

        int tobeSortSize = arr.length;
        while (tobeSortSize > 1) {
            swap(arr, 0, tobeSortSize - 1);
            tobeSortSize--;
            heapify(arr, tobeSortSize);
        }


        return arr;
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = temp;
    }

    private void heapify(int[] arr, int range) {
        int rootNodeIdx = range / 2 - 1;
        while (rootNodeIdx >= 0) {
            buildHeap(arr, rootNodeIdx, range);
            rootNodeIdx--;
        }
    }

    private void buildHeap(int[] arr, int rootIdx, int range) {
        while (2 * rootIdx + 1 < range) {
            int leftChildIdx = 2 * rootIdx + 1;
            int rightChildIdx = 2 * rootIdx + 2;
            int maxChildIdx = 2 * rootIdx + 1;
            if (rightChildIdx < range && arr[leftChildIdx] < arr[rightChildIdx]) {
                maxChildIdx = rightChildIdx;
            }
            if (arr[rootIdx] < arr[maxChildIdx]) {
                //如果root节点小于child
                //将root和maxChild节点交换
                int temp = arr[maxChildIdx];
                arr[maxChildIdx] = arr[rootIdx];
                arr[rootIdx] = temp;
                rootIdx = maxChildIdx;//递归调整这个被动过的子节点
            } else {
                return;
            }

        }

    }

    private void merge(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        merge(arr, left, mid);
        merge(arr, mid + 1, right);

        //do combine
        int L = left;
        int R = mid + 1;
        int[] temp = new int[right - left + 1];
        int idx = 0;
        while (L <= mid || R <= right) {
            if (L > mid) {
                temp[idx++] = arr[R++];
            } else if (R > right) {
                temp[idx++] = arr[L++];
            } else {
                if (arr[L] < arr[R]) {
                    temp[idx++] = arr[L++];
                } else {
                    temp[idx++] = arr[R++];
                }
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    //quick(arr,0,arr.length-1);
    private void quick(int[] arr, int left, int right) {
        if (right < 0 || left >= arr.length || (left >= right)) return;
        //random pivot & swap pivot to left, you can choose left.
        int pidx = left + (int) (Math.random() * (right - left));
        int pivot = arr[pidx];
        arr[pidx] = arr[left];
        arr[left] = pivot;

        int L = left;
        int R = right;

        boolean fromRight = true;
        while (L < R) {
            if (fromRight) {
                if (arr[R] < pivot) {
                    arr[L++] = arr[R];//R is empty,now needs to find a number > pivot from left
                    fromRight = !fromRight;
                } else {
                    R--;
                }
            } else {
                if (arr[L] > pivot) {
                    arr[R--] = arr[L];//L is empty,now needs to find a number < pivot from right
                    fromRight = !fromRight;
                } else {
                    L++;
                }
            }
        }
        arr[L] = pivot;

        quick(arr, left, L - 1);
        quick(arr, L + 1, right);
    }

    public int[] sortInsert(int[] arr) {
        //插入排序:从左往右遍历，将右边的元素插入到左边，确保左边有序，最后整体有序。
        for (int i = 2; i < arr.length; i++) {
            int pos = i;
            for (int prev = i; prev >= 0; prev--) {
                if (arr[pos] < arr[prev]) {
                    //swap with prev
                    int temp = arr[pos];
                    arr[pos] = arr[prev];
                    arr[prev] = temp;
                    pos = prev;
                } else {
                    break;//左边已经比它大了，不会和左边的数交换了，可直接break;
                }
            }
        }
        return arr;
    }

    public int[] sortSelect(int[] arr) {
        //选择排序:第一次选择一个最小的放在idx=0,之后每次选择次小的放到头部。
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}