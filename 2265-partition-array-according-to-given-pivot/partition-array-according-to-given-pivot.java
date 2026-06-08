class Solution {
    public int[] pivotArray(int[] arr, int pivot) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]<pivot) list.add(arr[i]);
        }
        for(int i=0;i<n;i++){
            if(arr[i]==pivot) list.add(arr[i]);
        }
        for(int i=0;i<n;i++){
            if(arr[i]>pivot) list.add(arr[i]);
        }
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = list.get(i);
        }
        return a;
    }
}