import java.util.Scanner;

public class BineeryTreeRecursion {

  public static void main(String[] args) {

    BinarySeachTreeRecurtion newtree = new BinarySeachTreeRecurtion();
    Scanner sc = new Scanner(System.in);
  

    // while(true){
    //   System.out.println("Enter the value to insert");
    //   int value = sc.nextInt();
    //   newtree.insert(value);
    //   System.out.println("Do you want to insert more?");
    //   String response = sc.next();
    //   if(response.equals("n")){
    //     break;
    //   }
    // }


    newtree.insert(10);
    newtree.insert(12);
    newtree.insert(2);
    newtree.insert(5);
    newtree.insert(3);
    newtree.insert(14);
    newtree.insert(11);
    newtree.insert(6);

    newtree.print();
   System.out.print("\n"+newtree.search(7));

   newtree.ansector(6);
  }
  
}



class TreeNode {

  int key;
  TreeNode left,right;
  public TreeNode(int item){
    key=item;
    left=right=null;
  }


}

class BinarySeachTreeRecurtion{
  TreeNode root;
  public BinarySeachTreeRecurtion(){
    root=null;
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
  public void insert(int val){
   root= insertRecord(root, val);

  }
  private TreeNode insertRecord(TreeNode current , int key){
    if(current == null){
        return new TreeNode(key);
    }
    if(key < current.key){
        current.left = insertRecord(current.left, key);
    }
    else if (key > current.key){
        current.right = insertRecord(current.right, key);
    }
    return current;
}

public boolean search(int key){
    return searchRec(root, key);
  }

private boolean searchRec(TreeNode current ,int key){
  if(current== null){
    return false;
  }
  if(current.key==key){
    return true;

  }

  if(current.key>key){
    return searchRec(current.left, key);
  }
  else if(current.key<key){
    return searchRec(current.right, key);
  }

return false;

}

public void ansector(int key){
  findAnsectors(root, key);
}


public void findAnsectors(TreeNode current,int key){

  if(current.key==key){
    System.out.println("all Ansectors found");
    return;

  }
  else{
    System.out.println("ansector "+current.key);
    if(current.key>key){
      findAnsectors(current.left, key);
    }
    else{
      findAnsectors(current.right, key);
    }
    
  }


}



public void descendents(TreeNode current, int key){
if(current==null){
System.out.println("complete descendents");
return;
}

else{
  
}



}

  
}