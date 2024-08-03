public class MergeSort {
    public static void main(String[] args) {
        int array[] ={2,1,3,4,5,632,56,346,3,4,34534,223};
        MergeSort mg =new MergeSort();
       // mg.print(array);
        mg.mergeSort(array,0,array.length-1);
        mg.print(array);
    }
    void mergeSort (int[] array,int l,int r){
        if (l <r) {
            int m = (l + r) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m+1, r);
             merge(array, l, m, r);
            return;
        }
      
    }
    void merge(int[] array ,int p,int q,int r){
        int n1 =q-p+1;
        int n2=r-q;
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];
        for(int i=0;i<n1;i++){
            leftArray[i]=array[p+i];
        }
        for(int j=0;j<n2;j++){
            rightArray[j]=array[q+1+j];
        }
int i,j,k;
j=0;
k=p;
i=0;

        while (i<n1 && j<n2){
         if( leftArray[i]<=rightArray[j]){
            array[k]=leftArray[i];
            i++;
         }
         else{
            array[k]=rightArray[j];
            j++;
         }
         k++;
        }

        while(i<n1){
            array[k]=leftArray[i];
            i++;
            k++;
        }
        while (j<n2) {
            array[k]=rightArray[j];
            j++;
            k++;
        }

    }
    void print (int[] array){
        for(int i=0;array.length>i;i++){
            System.out.print(array[i]+" ");
        }
    }
}
