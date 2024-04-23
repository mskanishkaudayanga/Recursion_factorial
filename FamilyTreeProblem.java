

import java.util.Scanner;

public class FamilyTreeProblem{
    public static void main(String[] args) {
        BST bst = new BST();

        // Insert members
        bst.insert(10,"A");
        bst.insert(5,"B");
        bst.insert(15,"C");
        bst.insert(2,"D");
        bst.insert(8,"E");
        bst.insert(12,"F");
        bst.insert(18,"G");
        bst.insert(7,"H");
        bst.insert(9,"I");
        System.out.println("All members added\n\n");

        System.out.println("-------------------------");
        bst.findAncestors(9);
        bst.findAncestors(12);

        System.out.println("-------------------------");
        bst.findDescendents(5);
        bst.findDescendents(15);

        System.out.println("-------------------------");
        bst.commonAncestor(2, 9);
        bst.commonAncestor(8, 18);
        bst.commonAncestor(18, 12);
        bst.commonAncestor(8, 7);
        bst.commonAncestor(2, 12);
        //bst.traverse();
    }
}

class TreeNode{
    int key;
    String name;
    TreeNode left,right;

    public TreeNode(int key, String name) {
        this.key = key;
        this.name = name;
        left = right = null;
    }
}

class BST{
    TreeNode root;

    public BST(){
        root = null;
    }

    public void insert(int key, String name){
        root = insertRec(root, key, name);
    }

    private TreeNode insertRec(TreeNode root, int key, String name){
        if(root==null){
            root = new TreeNode(key,name);
            return root;
        }

        if(key<root.key){
            root.left = insertRec(root.left,key,name);
        } else if(key>root.key){
            root.right = insertRec(root.right, key, name);
        } else{
            System.out.println("Already added");
        }

        return root;
    }

    public void findAncestors(int key){
        System.out.println("Searching for ancestors of : " + key);
        findAncestorRec(root,key);
    }

    private void findAncestorRec(TreeNode root, int key){
        if(key == root.key){
            System.out.println("All ancestors found\n\n");
            return;
        } else{
            System.out.println("Ancestor Found : " + root.key + " -- " +  root.name);
            if(key<root.key){
                findAncestorRec(root.left,key);
            } else{
                findAncestorRec(root.right, key);
            }
        }
    }

    public TreeNode findMember(int key){
        return findMemberRec(root,key);
    }

    private TreeNode findMemberRec(TreeNode root, int key){
        if(root == null || root.key == key){
            return root;
        } else {
            if(key<root.key){
                return findMemberRec(root.left,key);
            } else {
                return findMemberRec(root.right, key);
            }
        }
    }

    public void findDescendents(int key){
        System.out.println("Searching for descendents of : " + key);
        TreeNode member = findMember(key);
        if(member == null){
            System.out.println("Member not found\n\n");
        } else {
            findDescendentsRec(member.left,key);
            findDescendentsRec(member.right,key);
        }
        System.out.println("\n");
    }

    private void findDescendentsRec(TreeNode root, int key){
        if(root==null){
            return;
        } else{
            System.out.println("Descendent Found : " + root.key + " -- " + root.name);
            findDescendentsRec(root.left, key);
            findDescendentsRec(root.right,key);
        }


    }

    public void commonAncestor(int key1, int key2){
        System.out.println("Finding common ancestor of : " + key1 + " and " + key2);
        commonAncestorRec(root, key1, key2);
    }

    private void commonAncestorRec(TreeNode root, int key1, int key2){
        if(root==null){
            System.out.println("No ancestors found\n");
            return;
        } else {
            if(root.key == key1 || root.key == key2){
                System.out.println("Most recent common ancestor is : " + root.key + " -- " + root.name);
                return;
            } else if((key1 < root.key && key2 > root.key) || (key2 < root.key && key1 > root.key)){
                System.out.println("Most recent common ancestor is : " + root.key + " -- " + root.name);
                return;
            } else if(key1 < root.key && key2 < root.key){
                commonAncestorRec(root.left, key1, key2);
            } else if(key1 > root.key && key2 > root.key){
                commonAncestorRec(root.right, key1, key2);
            }
            return;
        }
    }
}


