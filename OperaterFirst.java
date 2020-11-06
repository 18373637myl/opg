import java.util.*;

public class OperaterFirst{
    MyStack stack = new MyStack();
    String sentence = new String();
    MyStack sen = new MyStack();
    Matrix matrix = new Matrix();

    public OperaterFirst(String sentence){
        this.sentence = sentence;
        sen.push('#');
        for(int i=sentence.length()-1; i>=0; i--){
            sen.push(sentence.charAt(i));
        }
    }

    public int gethash(char a){
        return matrix.map.get(a);
    }

    public boolean isVt(char a) { return a=='i' || a=='+' || a=='*' || a=='#' || a=='(' || a==')'; }

    public char searchLastVt(){
        for(int i=0; i<stack.size(); i++){

            if(isVt(stack.getLast(i))){
                //寻找前一个终结符
                return stack.getLast(i);
            }

        }
        return 0;
    }

    public void OperaterFirstMethod(){

        stack.push('#');
        char last_symbol = '#';

        while(!sen.stack_empty()){

            char in_top = stack.getLast(0);
            char next = sen.getLast(0);
            int prio_1 = gethash(last_symbol);
            int prio_2 = gethash(next);

            if(!isVt(last_symbol) || !isVt(next)){
                //符号不能识别输出E
                System.out.println("E");
            }

            else if(matrix.arr[prio_1][prio_2] == '=' || matrix.arr[prio_1][prio_2] == '<' ){
                //移进
                char a = sen.pop();
                stack.push(a);
                last_symbol = a;
                if(a!='#') System.out.println("I"+a);
            }

            else if(matrix.arr[prio_1][prio_2] == '>'){
                //规约
                if(stack.top() == 'i'){
                    //对 N::=i 进行规约
                    stack.pop();
                    stack.push('N');
                    last_symbol = searchLastVt();
                    System.out.println("R");
                }

                else if(last_symbol == '+' || last_symbol == '*' || last_symbol == ')'){
                    //对 N::= N+N N::= N*N N::=(N)进行规约
                    StringBuilder now = new StringBuilder();
                    for(int i=2; i>=0; i--) now.append(stack.getLast(i));
                    if(now.toString().equals("N+N") || now.toString().equals("N*N") || now.toString().equals("(N)")){
                        for(int i=0; i<3; i++) stack.pop();
                        stack.push('N');
                        last_symbol = searchLastVt();
                        System.out.println("R");
                    }
                    else{
                        System.out.println("RE");
                        break;
                    }
                }

            }
            else if(last_symbol=='#'&&next=='#'){
                break;
            }
            else{
                //无法判断优先级关系输出E
                System.out.println("E");
                break;
            }

        }


    }
}
