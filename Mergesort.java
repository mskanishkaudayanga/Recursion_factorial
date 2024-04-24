class Mergesort{
  // first we have to divide arry to sub arry by using middle point of array. 
  // after dividing elements should be single arry element.
  // then we have to merge the elements by comparing the elements.

  // fist we can create a method to divide the array.
  // fist we have choose midle point of array. 
  // for this lower bound and upper bound of arry sumation divide by 2
  // m= (lb+ub)/2

  void mergeSort(int arr[],int l , int r){
    if(l<r){
      int m = (l+r)/2;
      //now we have middle point 
      // we have to divide the array into two parts
      // like ass left and right arrys using recurson
      mergeSort(arr, l, m); // this is left og middle point
      mergeSort(arr, m+1, r);

    // and we have to merge it we create another methord for it
    merge(arr ,l ,m,r);
      
    }

  }

  private void merge(int[] arr, int p, int q, int r) {
    //p is lower bound 
    //q is middle
    //r is upper bound

    int n1 = q-p+1;
    int n2 = r-q;

    // n1 n2 is a left and right sub arry lenghts

    // add elements this tho array and crete arry left and right

    int L[] =new int[n1];
    int M[]= new int[n2];
    
    for (int i=0 ; i<n1 ;i++){
      L[i]=arr[p+i];
    }
    for (int j=0 ; j<n2;j++){
      M[j]= arr[q+1+j];
    }

// maintain current index of sub arrys
int i,j,k;
i=0;
j=0;
k=p;

// merging

while(i<n1 && j< n2){
if(L[i]<=M[j]){
  arr[k]=L[i];
  i++;

}
else {
  arr[k]=M[j];
  j++;
}
k++;
}

// the one sub arry is larger than another one sorted arry merge nomally
while(i<n1){
  arr[k]=L[i];
  i++;
  k++;

}

while(j<n2){
  arr[k]=M[j];
  j++;
  k++;
  
}

  }
  // this is a merge sort functions
  // thanks for watching

  static  void printArry(int arr[]){
    int n=arr.length;
    for(int i=0; i<n;i++){
      System.out.print(arr[i]+" ");
    }

  }
  public static void main(String[] args) {
    int arry[]= {3,5,1,46,35,2546,5743,35,32,34,6,8};
    printArry(arry);
    Mergesort ob = new Mergesort();
    ob.mergeSort(arry, 0, arry.length-1);
    System.out.println("sorted array");
    printArry(arry);
  }
}
