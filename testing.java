public class testing {
  public static void main(String[] args) {

    BinaryTree bst = new BinaryTree();

    bst.insert(10);
    bst.insert(14);
    bst.insert(11);
    bst .insert(5);
    bst.insert(4);
    bst.insert(8);
    
    System.out.println(bst.search(10));
    bst.printing();
    bst.Ansectors(8);
    System.out.println(bst.lcAnsentor(8,11));

  }
}
class TreeNode{
  int key ;
  TreeNode left, right;
  public TreeNode(int item){
   key=item;
    left=right=null;
  
  }

}
class BinaryTree{
  
  TreeNode root;
  public BinaryTree(){
    root=null;
  }


  public void insert(int key){
   root= insertRec(root,key);
  }


  public TreeNode insertRec(TreeNode root, int key){

    if(root==null){
      return new TreeNode(key);
    }

    if(root.key>key){
      root.left=insertRec(root.left, key);
    }
    if(root.key<key){
      root.right=insertRec(root.right, key);
    }

    return root;
  }

  public boolean search(int key){
    return searchRec(root,key);
  }

  private boolean searchRec(TreeNode root ,int key){

    if(root== null){
      return false;
    }
    if(root.key == key){
      return true;
    }
    if(root.key<key){
      return searchRec(root.right, key);
    }
    else if(root.key >key){
      return searchRec(root.left,key);
    }

    return false;
  }


  public void printing(){
    printRec(root);
  }

  public void printRec(TreeNode node){
    if (node!=null) {
      printRec(node.left);
      System.out.println(node.key);
      printRec(node.right);
    }
  }
public void Ansectors(int key){
  AnsectorsRec(root, key);
}

public void AnsectorsRec(TreeNode current, int key){
  if(current.key==key){
    return ;

  }
else{

  System.out.println("ansestor :" + current.key);
  if(current.key<key){
    AnsectorsRec(current.right, key);
  }
  if(current.key>key){
    AnsectorsRec(current.left, key);
  }


}





  
}

public int lcAnsentor(int n1 ,int n2 ){
  return lcAnsentorRec(n1,n2,root);
}

public int lcAnsentorRec(int n1,int n2,TreeNode current){


  if(root==null){
    return -1;
  }

  if(current.key>n1 && current.key>n2){
    return lcAnsentorRec(n1, n2, current.left);
  }
  else if(current.key<n1 && current.key<n2){
    return lcAnsentorRec(n1, n2, current.right);
  }
  else
  {
    return current.key;
  }
 
  
}





}