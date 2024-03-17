import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class MoreRecurtion {


  


  public int questionOne (int i){
    if (i==0){
      return 1;
    }
    else 
    return i* questionOne(i-1);
   
  }


  public boolean palindrome(String s){
   if (s.length()== 0 || s.length()==1){
    return true;
   }
   if (s.charAt( 0) != s.charAt(s.length()-1)){
    return false;
   }

   
 
    return palindrome(s.substring(1,s.length()-1));
  }


  public int sumOfdigits(int i ){
    if (i==0){
      return 0;
    }


    return i%10 + sumOfdigits(i/10);

  }



  public int fibonaci(int i){

if(i==0){
  return 0;

}
if (i==1){
  return 1;
}

return fibonaci(i-1)+fibonaci(i-2);

  }


  public int power(int i,int j){

    if (i==0){
      return 0;
    }
    if(j==0){
      return 1;
    }

    int ans =i*power(i,j-1);
    j=j-1;

    return ans;


  }


  // public int GDB(int i,int j){


  //   if(i<j){
  //     if (j%i==0 &&  i%j==0) {
  //       return i;
        
  //     }
  //   return  GDB(i-1, j);

  //   }
  //   else{
  //     if (j%i==0 &&  i%j==0) {
  //       return j;
        
  //     }
  //  return   GDB(i, j-1);
  //   }

    
    
    



  // }

  public int GDB(int i, int j) {
    if (j == 0) {
        return i;
    } else {
        return GDB(j, i % j);
    }
}


public int[] reverseArray(int[] arry ,int begin, int end){
  if (begin>=end){
    return arry;
  }

 int temp = arry[begin];
 arry[begin]=arry[end];
 arry[end]=temp;

  return reverseArray(arry, begin+1, end-1);

}

public static void main(String [] args){
   MoreRecurtion factorial =new MoreRecurtion();
   int x; 
    Scanner sc =new  Scanner(System.in);
    // System.out.println("enter number");
    // x = sc.nextInt();
    
    // while(x<0){
    //   System.out.println("enter positive number");
    //   x = sc.nextInt();

    // }
  
//System.out.println( factorial.questionOne(x));

// System.out.println(factorial.palindrome("leqvel"));

// System.out.println(factorial.sumOfdigits(12));
System.out.println(factorial.fibonaci(0));
System.out.println(factorial.power(2, 6));
System.out.println(factorial.GDB(36, 6));

System.out.println(Arrays.toString(factorial.reverseArray(new int[]{1,2,3,4,5,6}, 0, 5)));

}

}

  

