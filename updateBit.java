import java.lang.Math; 
import java.lang.StringBuilder;

public class updateBit
{
  public static void main(String[] args)
  {
    HelloWorld.updateBit(HelloWorld.updateBit(HelloWorld.updateBit(-10,0,0),1,0),2,0);
    HelloWorld.updateBit(HelloWorld.updateBit(HelloWorld.updateBit(15,0,0),1,0),2,0);
    HelloWorld.updateBit(HelloWorld.updateBit(HelloWorld.updateBit(16,0,1),1,1),2,1);
}
    public static void printInBin(int x){
    StringBuilder sb = new StringBuilder();
    System.out.print(x+ " in bin: ");
    for (int i=31;i>=0;i--){
      if (x%2==0){
      sb.append("0");
      }else sb.append("1");;
      x>>>=1;
    }
  sb.reverse().append("\n");
  System.out.print(sb);
  }
  public static int updateBit(int x, int pos, int value){
    int result;
  if (value==0) {result = x&~(1<<pos); printInBin(result); return result;}
  else if (value==1) {result = x|(1<<pos); printInBin(result); return result;}
  printInBin(x);
  
  return x;
  }
}
