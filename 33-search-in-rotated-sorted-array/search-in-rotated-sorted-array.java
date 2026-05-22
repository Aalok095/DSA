class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int lo = 0,hi = n-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<=arr[hi]){ // we are in right sorted part
                if(target>arr[mid] && target<=arr[hi]) lo = mid+1;
                else hi = mid-1; 
            }
            else { // we are in left sorted part
                if(target<arr[mid] && target>=arr[lo]) hi = mid-1;
                else lo = mid+1; 
            }
        }
        return -1;
    }
}