class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length<=1) return nums;
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    void mergeSort(int[] a,int l,int r){
        if(l>=r) return;
        int m = l+(r-l)/2;
        mergeSort(a,l,m);
        mergeSort(a,m+1,r);
        merge(a,l,m,r);
    }

    void merge(int[] a,int l,int m,int r){
        int[] tmp = new int[r-l+1];
        int i=l,j=m+1,k=0;
        while(i<=m && j<=r){
            if(a[i]<=a[j]) tmp[k++]=a[i++];
            else tmp[k++]=a[j++];
        }
        while(i<=m) tmp[k++]=a[i++];
        while(j<=r) tmp[k++]=a[j++];
        for(int x=0;x<tmp.length;x++){
            a[l+x]=tmp[x];
        }
    }
}
