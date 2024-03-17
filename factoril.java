public class factoril{

  public int findFactorial(int i){

    if (i==0 || i==1){
      return 1;
    }
    return i*findFactorial(i-1);
  }

  public static void main(String[] args){

    factoril findFact =new factoril();
     
    System.out.println(findFact.findFactorial(1));

  }
}