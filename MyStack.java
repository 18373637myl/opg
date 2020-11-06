import java.util.*;


public class MyStack {
    List<Character> stack = new ArrayList<Character>();

    public MyStack(){}

    public boolean stack_empty(){
        return stack.size() == 0;
    }

    public char pop(){
        if(!stack_empty()){
            char a = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return a;
        }
        return 0;
    }

    public void push(char a){ stack.add(a); }

    public char get(int index){ return stack.get(index); }

    public char getLast(int index){ return stack.get(stack.size()-index-1); }

    public char top() { return getLast(0); }

    public int size() { return stack.size(); }
}
