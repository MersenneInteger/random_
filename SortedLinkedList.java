import java.util.Scanner;

public class SortedLinkedList{

    public static class Node extends SortedLinkedList{

	int num;
	Node next;
	
	public Node(int n){
	    num = n;
	    next = null;
	}

	public static void printList(Node top){

	    while(top != null){

		System.out.print(top.num + " ");
		top = top.next;
	    }
	    System.out.println();
	}

	public static Node addInPlace(Node top,int n){

	    Node np, prev, curr;
	    np = new Node(n); //initialize np with n
	    prev = null; 
	    curr = top;

	    while(curr != null && n > curr.num){ //as long as n > number being
		                                //compared to 
		prev = curr; 
		curr = curr.next;
	    }
	    
	    np.next = curr; 
	    if(prev == null)return np; //if loop does not iterate, np is top
	    prev.next = np; 

	    return top;
	}

	    public static void main(String[] args){

		Scanner kb = new Scanner(System.in);
		Node top;
		top = null;
		int n = 0;
	
		System.out.println("Enter a sequence of numbers ending with zero");
		kb.nextInt();

		while(n != 0){

		    top = Node.addInPlace(top, n);
		    kb.nextInt();
		}

		Node.printList(top);
		kb.close();
	  
	    }//end of main
    }//end of Node

}//end of class
