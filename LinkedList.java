import java.util.*;

public class LinkedList{

    class NodeData{
	
	int num;
    public NodeData(int n){num = n;}

    public int compareTo(NodeData nd){
	if(this.num == nd.num)return 0;
	if(this.num < nd.num)return -1;
	return 1;
    }
    public String toString(){ return num + " ";}
    }//end of NodeData
    
    class Node{

	NodeData data;
	Node next;

	public Node(NodeData nd){
	    data = nd;
	    next = null;
	}
    }//end of Node

      class LinkedList{

	Node head = null;

	public boolean empty(){return head == null;}
	public void addInPlace(NodeData nd){

	Node np, curr, prev;

	np = new Node(nd);
	prev = null;
	curr = head;
	while(curr != null && nd.compareTo(curr.data) > 0){

	    prev = curr;
	    curr = curr.next;
	}
	np.next = curr;
	if(prev == null)head = np;
	else prev.next = np;
    }

	public void print(){	    

	    Node curr = head;
	    while(curr != null){
	    System.out.print(curr.data + " ");
	    curr = curr.next;
	    }

	    System.out.println();
	}

	public void addHead(Nodedata nd){

	    Node p = new Node(nd);
	    p.next = head;
	    head = p;
	}
    }//end of List
     
    public static void main(String[] args){

	Scanner kb = new Scanner(System.in);
	LinkedList l = new LinkedList();
	System.out.println("Enter integers ending with 0.");
	int n = kb.nextInt();

	while(n != 0){

	    l.addInPlace(new NodeData(n));
	    n = kb.nextInt();
	}
	l.print();
	
    }//end main
}//end class

/*
    public static class Node{

	int num;
	Node next;

        public Node(){next = null;}
	public Node(int n){

	    num = n;
	    next = null;
	}

	public static int length(Node top){

	    int n = 0; //counter
	    Node curr = top;
	    while(curr != null){

		n++;
		curr = curr.next; //move to next node
	    }
	    return n; //returns number of nodes
	}

	public static Node search(Node top, int n){

	    while(top != null && n != top.num)
		top = top.next; //move to next node

	    return top;
	}
*/
