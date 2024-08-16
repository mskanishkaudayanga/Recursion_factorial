import java.util.ArrayList;
import java.util.LinkedList;

public class GraphMain {
    public static void main(String[] args) {
        Graph graph =new Graph(3);
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addEdge(1, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 0);
       graph.print();


       // linked list implimentation
       GraphByList gr =new GraphByList(5);
       gr.addNode(new Node('A'));
       gr.addNode(new Node('B'));
       gr.addNode(new Node('C'));
       gr.addNode(new Node('D'));
       gr.addNode(new Node('E'));
       gr.addEdge(0, 1);
       gr.addEdge(1, 2);
       gr.addEdge(1, 4);
       gr.addEdge(2, 3);
       gr.addEdge(2, 4);
       gr.addEdge(4, 0);
       gr.addEdge(4, 2);
      gr.print();
    }
}
//create node 
class Node{
    char data ;
    Node(char data){
        this.data=data;
    }
}

//Matrix impimentation in ghraph
class Graph{
    private int[][] adjancymatrix;
    private int numvertices;
    ArrayList<Node> nodes;
    
    public Graph(int numvertices){
        this.numvertices=numvertices;
        adjancymatrix =new int[numvertices][numvertices];
        nodes=new ArrayList<>();

    }
    public void addNode(Node node){
        nodes.add(node);

    }
    public void addEdge(int src,int dst){
       // if(src>=0 && src<numvertices && dst>=0 && dst<numvertices){}
        adjancymatrix[src][dst]=1;

    }
    public boolean checkEdges(int src,int dst){
        if(adjancymatrix[src][dst]==1){
            return true;
        }
        else return false;
    }
    public void print(){
        for(int i=0;i<numvertices;i++){
            for(int j=0;j<numvertices;j++){
                System.out.print(adjancymatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
// impliment adjacency list 
class GraphByList{
//  private int numvertices;
//  private LinkedList[] adjencyList;
//  public GraphByList(int numvertices){
//     this.numvertices=numvertices;
//     adjencyList=new LinkedList[numvertices];
//     for(int i=0;i<numvertices;i++){
//         adjencyList[i]=new LinkedList<>();
        
//     }
//  }


ArrayList<LinkedList<Node>> alist;
private int numvertices;
public GraphByList(int numvertices){
    this.numvertices=numvertices;
    alist=new ArrayList<>();
}

public void addNode(Node node){
//createlinklist
LinkedList<Node> currentList =new LinkedList<>();
currentList.add(node);//add new node to linked list 
alist.add(currentList);//add linked list to arry list

}
public void addEdge(int src,int dst){
    LinkedList<Node> currentlist = alist.get(src);
    Node destNode= alist.get(dst).getFirst();
    currentlist.add(destNode);
}
public Boolean checkEdges(int src,int dst){
    LinkedList<Node> currentList = alist.get(src);
    Node dstNode = alist.get(dst).get(0);
    for (Node node : currentList) {
        if(node==dstNode){
            return true;
        }
        
        
    }
    return false;

}
public void print(){
    for (LinkedList<Node> linkedList : alist) {
        for (Node node : linkedList) {
            System.out.print(node.data + "->");
        }
        System.out.println();
        
    }

}

}