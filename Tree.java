import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Tree {
    public static void main(String[] args) {
        BinarySearchTree newTre = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int arr[]={20,60,50,45,70,10,15,18,12};
        // while(true){ 

        // System.out.println("enter value for node");
        // int value = sc.nextInt();
        for (int i : arr) {
            newTre.insert(i);
        }
       
        // System.out.println("enter more (y/n) ");
        // String response =sc.next();
        // if (response.equals("n")) {
        //     break;  
        // }
   // }
        newTre.print();
        //newTre.deleteLeafNode(12);
        //newTre.deledeOneChildNode(50);
        //newTre.deleteMoreChlilds(60);
        System.out.println("after deletion");
       // newTre.print();
        newTre.bfs(newTre.root);
    }
}
// class TreeNode{
//     int key;
//     TreeNode left, right;
//    public TreeNode(int item){
//         key=item;
//         left=right=null;
//     }
// // }
//  class BinarySeachTree{
//     TreeNode root;
//     public BinarySeachTree(){
//         root=null;
//     }
//     public void insert(int item){
//         root =insertRec(item, root);
//     }
//     private TreeNode insertRec(int key ,TreeNode root){
//         if(root==null){
//             root=new TreeNode(key);
//             return root;
//         }
//         if(key<root.key){
//             root.left=insertRec(key, root.left);
//         }
//         if(key >root.key){
//             root.right=insertRec(key, root.right);
//         }
//         return root;
//     }
//     public void print(){
//         printRec(root);
//     }
//     private void printRec(TreeNode root){
//         if(root!=null){
//             printRec(root.left);
//             System.out.println(root.key);
//             printRec(root.right);
//         }
//     }
// }

class TreeNode{
    int key;
    TreeNode left,right;
    public TreeNode(int item){
        key=item;
        left=right=null;
    }
}
class BinarySearchTree{
    TreeNode root;
    public BinarySearchTree(){
        root=null;
    }
    public void insert(int key){
        root=insertRec(root, key);
    }
     private TreeNode insertRec(TreeNode root,int key){
        if(root==null){
            root=new TreeNode(key);
        }
        if(root.key>key){
            root.left=insertRec(root.left, key);
        }
        if(root.key<key){
            root.right=insertRec(root.right, key);
        }

        return root;
     }

         public void print(){
        printRec(root);
    }
    private void printRec(TreeNode root){
        if(root!=null){
            printRec(root.left);
            System.out.println(root.key);
            printRec(root.right);
        }
    }

    public void deleteLeafNode(int key){
        root=deleteLeafNodeREC(root, key);
    }
    private TreeNode deleteLeafNodeREC(TreeNode root,int key){
        if(root==null)return null;

        if(key<root.key){
            root.left=deleteLeafNodeREC(root.left, key);
        }
       else if(key>root.key){
            root.right=deleteLeafNodeREC(root.right, key);
        }
        else{
           root=null; 
        }
        return root;
    }

    public void deledeOneChildNode(int key){
        root=deleteOneChildRec(root, key);
    }
    private TreeNode deleteOneChildRec(TreeNode root,int key){
        if(root==null)return null;
        if(key<root.key){
            root.left=deleteOneChildRec(root.left, key);
        }
        else if(key>root.key){
            root.right=deleteOneChildRec(root.right, key);
        }
        else{
            if(root.left==null)return root.right;
            if(root.right==null)return root.left;
        }
        return root;
    }
    public void deleteMoreChlilds(int key){
        root=deleteMoreChildRec(root, key);
    }
    private TreeNode deleteMoreChildRec(TreeNode root,int key){
        if(root==null)return null;
        if(key<root.key){
            root.left=deleteMoreChildRec(root.left, key);
        }
        else if(key>root.key){
            root.right=deleteMoreChildRec(root.right, key);
        }
        else {
            TreeNode succesor = findSuccesser(root);
            root.key=succesor.key;
            root.right=deleteMoreChildRec(root.right,succesor.key);
        }
        return root;
    }
    private TreeNode findSuccesser(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void bfs(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue =new LinkedList<>();
     queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node =queue.poll();
            System.out.println(node.key+" ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }
}
