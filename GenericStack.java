import java.util.ArrayList;
//generics allows for error detection at compile time not runtime
public class GenericStack<E>{

	private ArrayList<E> list = new ArrayList<>();

	public int getSize(){
	    return list.size();
	}
	public E peek(){
	    return list.get(getSize()-1);
        }
    
       public void push(E o){
	   list.add(o);
       }
	   public E pop(){
	       E o = list.get(getSize() - 1);
	       list.remove(getSize()-1);
	       return o;
	   }

	  public boolean isEmpty(){
	      return list.isEmpty();
	  }
	  public String toString(){
	    return "stack: " + list.toString();
	 }

    public static <E> void print(E[] list){

	for(int i = 0; i < list.length; i++)
	    System.out.print(list[i] + " ");
	System.out.println();

    }
    public static <E extends Comparable <E>> void sort(E[] list){

	for(int i = 0; i < list.length; i++){
	    for(int j = 0; j <list.length - 1; j++){
		if(list[j].compareTo(list[i]) > 0){
		E temp = list[j];
		list[j] = list[i];
		list[i] = temp;
		}		
	    }
	}
    }

    public static double max(GenericStack<? extends Number> stack) {
	// ? = unbounded wildcard
	// ? extends T = bounded wildcard
	// ? super T = lower-bound wildcard

	double max = stack.pop().doubleValue();

	while(!stack.isEmpty()){

	    double value = stack.pop().doubleValue();
	    if(value > max)
		max = value;
	}
	return max;
    }
	
    public static void main(String[] args){

	GenericStack<String> st = new GenericStack<>();
	GenericStack<Integer> in = new GenericStack<>();
	
	st.push("Pikachu");
	st.push("Charmander");
	System.out.println("Peeking: " + st.peek());

	in.push(3);
	in.push(87);
	System.out.println("Peeking: " + in.peek());

        Integer[] ints = {2,3,5,7,11};
	String[] str = {"this", "is", "a", "string"};

        print(ints);
	print(str);

	System.out.print("Sorted: ");
	sort(ints);
	print(ints);

        GenericStack<Integer> iStack = new GenericStack<>();
	iStack.push(1);
	iStack.push(2);
	iStack.push(-2);

	System.out.println("The max number is " + max(iStack));
	

	

    }//end of main

}//end of class

