import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
public class HelloWorld{

    public static final int TOWERS = 3;
    public static final int DISCS = 4;
    
    private static List<Stack<Integer>> towers = new ArrayList<Stack<Integer>>();
    
    public static void moveDist(Stack<Integer> from, Stack<Integer> to){
        to.push(from.pop());
    }
    public static void solveHannoi(){
        if(towers.get(TOWERS-1).size()==TOWERS) return;
        Stack<Integer> A = towers.get(0);
        Stack<Integer> B = towers.get(1);
        Stack<Integer> C = towers.get(2);
    moveDiscs(DISCS,A,C,B);
    }

    public static void moveDiscs (int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> temp){
        if (n==0) return;
        Stack<Integer> A = towers.get(0);
        Stack<Integer> B = towers.get(1);
        Stack<Integer> C = towers.get(2);
        String fromName;
        fromName = from==A?"A":(from==B?"B":"C");
        String toName;
        toName = to==A?"A":(to==B?"B":"C");

        moveDiscs(n-1,from,temp,to);
        System.out.println("Moving "+ from.peek()+" from "+fromName+" to "+toName);
        moveDist(from,to);
        //printTowers();
        moveDiscs(n-1,temp,to,from);
    }
    public static void initialiseHannoi(){
        for (int i=0;i<TOWERS;i++){
            towers.add(new Stack<Integer>());
        }
        for (int i=DISCS;i>=1;i--){
            (towers.get(0)).push(i);
        }
    }
    
    public static void printTowers(){
        for (int i=0;i<TOWERS;i++){
            System.out.print("TOWER "+((char)(i+65))+": ");
            for (Integer n:towers.get(i)){
             System.out.print(n+",");
            }
            System.out.println();
        }
    }
     public static void main(String []args){
        System.out.println("Hello World");
        HelloWorld.initialiseHannoi();
        System.out.println("Initial State");
        HelloWorld.printTowers();
        HelloWorld.solveHannoi();
        System.out.println("Final State");
        HelloWorld.printTowers();

     }
}
