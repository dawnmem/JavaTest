package com.junit;


public class testCode 
{
    public void sort(int[] arr,String px){
        switch(px){
            case "cr":crsort(arr, 1);break;
            case "xe":xesort(arr, arr.length);break;
            case "ks":kssort(arr, 0, arr.length-1);break;
            case "gb":{
                int[] current = new int[arr.length];
                gbsort(0, arr.length-1, arr, current);
                break;
            }
        }
    }
    public void crsort(int[] arr, int index) {
        int target = index;
        int current = arr[index];
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] > current) {
                arr[i + 1] = arr[i];
                target = i;
            } else {
                break;
            }
        }
        arr[target] = current;
        index++;
        if (index < arr.length) {
            crsort(arr, index);
        }
    }

    public void xesort(int[] arr, int gap) {
        gap = gap / 2;
        for (int i = 0; i < gap; i++) {
            for (int j = i + gap; j < arr.length; j += gap) {
                int current = arr[j];
                for (int k = j - gap; k >= i; k -= gap) {
                    if (arr[k] > current) {
                        arr[k + gap] = arr[k];
                        arr[k] = current;
                    }
                }
            }
        }
        if (gap > 1) {
            xesort(arr, gap);
        }
    }

    public void kssort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[left];
            int begin = left;
            int end = right;
            while (right > left) {
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    left++;
                } else {
                    right--;
                    continue;
                }
                while (right > left) {
                    if (arr[left] > pivot) {
                        arr[right] = arr[left];
                        right--;
                        break;
                    } else {
                        left++;
                    }
                }
            }
            arr[left] = pivot;
            kssort(arr, begin, left - 1);
            kssort(arr, left + 1, end);
        }
    }

    public void gbsort(int left, int right, int[] arr, int[] current) {
        if (left < right) {
            int mid = (left + right) / 2;
            gbsort(left, mid, arr, current);
            gbsort(mid + 1, right, arr, current);
            merge(left, right, mid, arr, current);
        }
    }
 
    public void merge(int left, int right, int mid, int[] arr, int[] current) {
        int i = 0;
        int j = left;
        int k = mid + 1;
        while (j <= mid && k <= right) {
            if (arr[j] < arr[k]) {
                current[i] = arr[j];
                i++;
                j++;
            } else {
                current[i] = arr[k];
                i++;
                k++;
            }
        }
        while (j <= mid) {
            current[i] = arr[j];
            i++;
            j++;
        }
        while (k <= right) {
            current[i] = arr[k];
            i++;
            k++;
        }
        for (int t = 0; t < i; t++) {
            arr[left + t] = current[t];
        }
    }
}
