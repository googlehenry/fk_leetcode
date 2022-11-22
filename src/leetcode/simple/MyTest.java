package leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4,5,3,6,8};
        mSort(arr,0,arr.length-1);
        System.out.println(arr);
    }

    /**
     * 归并排序手写
     * @param arr
     * @param start
     * @param end
     */
    public static void mSort(int[] arr, int start, int end){


        if(start>=end){
            return;
        }

        int mid = start+(end-start)/2;

        mSort(arr,start,mid);
        mSort(arr,mid+1,end);

        merge(arr,start,mid,end);

    }

    public static void merge(int[] arr, int start, int mid, int end){
        int[] arrTemp = new int[end-start+1];

        int i = start;
        int j = mid+1;

        int k = 0; //any partial arr

        while(i<=mid&&j<=end){
            if(arr[i]<arr[j]){
                arrTemp[k++] = arr[i++];
            }else{
                arrTemp[k++] = arr[j++];
            }
        }

        //process not 1-one
        while(i<=mid){
            arrTemp[k++] = arr[i++];
        }
        while(j<=end){
            arrTemp[k++] = arr[j++];
        }
        //store back
        for(int x=start;x<=end;x++){
            arr[x] = arrTemp[x-start];
        }
    }


}
