public class ArrayStack<E> implements Stack<E>{

    public static final int CAP = 1000;
    private E[] data;
    private int t = -1;
    public ArrayStack(){ this(CAP); }
    public ArrayStack(int capacity){
        data = (E[]) new Object[capacity];
    }
    public int size() { return (t+1);}
    public boolean isEmpty() { return (t == -1); }
    
    public void push(E e) throws IllegalStateException{
    
        if(size() == data.length) throw new IllegalStateException("Stack is full.");
        data[++t] = e;                                                              
    }
    public E top(){
        if(isEmpty()) return null;
        return data[t];
    }
    public E pop(){
    
        if(isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
                                                                                    
    }
    
    public static void main(String[] args){
        
        ArrayStack<Integer> S = new ArrayStack<>();
        S.push(5);
        System.out.println("Top of stack: " +  S.top());
        S.push(4);
        System.out.println("Top of stack: " +  S.top());
        S.push(99);
        System.out.println("Top of stack: " +  S.top());
        S.pop();
        System.out.println("Popping..." + S.top());
        S.pop();
        S.pop();
        System.out.println("Top: " +  S.top());
                                                                                    
    }//end of main                                                                            
}//end of ArrayStack
