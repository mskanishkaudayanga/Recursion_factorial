public class quickSort {
    public static void main(String[] args) {
        quickSort quick = new quickSort();
        int array[]={12,31,341,4,21,4,57,6,54,32,1,0};
       quick.quickSorting(array,0,array.length-1);
      quick.print(array);
    }
    int partitoning(int[] array,int low, int high){
        int pivotal =array[low];
        int left =low+1;
        int right=high;

        while(left<=right){
            while(left<=right && array[left]<=pivotal){
                left++;
            }
            while(left<=right && array[right]>pivotal){
                right--;
            }
            if(left<right){
                Swap(array, left, right);
            }
        }
        Swap(array, low, right);
        return right;
    }
    void Swap(int[] array, int a, int b){
        int temp =array[a];
        array[a]=array[b];
        array[b]=temp;  
    }
  void  quickSorting(int[] array,int low,int high){
    if(high>low){
        int pivotIndex =partitoning(array, low, high);
        quickSorting(array, low, pivotIndex-1);
        quickSorting(array, pivotIndex+1, high);
    }
    
  } 
  void print(int[] array){
    for (int i=0 ; array.length-1>i;i++) {
        System.out.print(array[i]+" ");
        
    }
  }
}
