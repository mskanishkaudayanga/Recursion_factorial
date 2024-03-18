import java.util.Scanner;

public class BineryTree {
  public static void main(String[] args){

    BinerySeachTree newtree =new BinerySeachTree();

Scanner sc = new Scanner(System.in);
  

    while(true){
      System.out.println("Enter the value to insert");
      int value = sc.nextInt();
      newtree.insertion(value);
      System.out.println("Do you want to insert more?");
      String response = sc.next();
      if(response.equals("n")){
        break;
      }
    }

    newtree.print();


   

  }
}


 class TreeNode{
  int key;
  TreeNode left,right;

  public TreeNode(int item){
    key=item;
    left=right=null;
    
  }
}
 
class BinerySeachTree{
  TreeNode root;
  public BinerySeachTree(){
    root=null;
  }

  public void insertion(int val){
    TreeNode newNode = new TreeNode(val);

    if(root==null){
      root=newNode;
    }
    else{
      TreeNode current =root;
      while(true){

        if(val<current.key){
          if(current.left==null){
            current.left=newNode;
            return;
          }
          else{
            current=current.left;
          }

        }
        else{
          if(current.right==null){
            current.right=newNode;
            return;
          }
          else{
            current=current.right;
          }
        }
      }
    }

  }



  public void inOrderPrint(TreeNode node) {
    if (node != null) {
      inOrderPrint(node.left);
      System.out.print(" " + node.key);
      inOrderPrint(node.right);
    }
  }

  // Method to start the print process from the root
  public void print() {
    inOrderPrint(root);
  }

}
