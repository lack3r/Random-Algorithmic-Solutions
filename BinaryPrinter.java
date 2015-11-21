public static void printInBin(int x){
  StringBuilder sb = new StringBuilder();
  System.out.print(x+ " in bin: ");
  for (int i=31;i>=0;i--){
    if (x%2==0){
    sb.append("0");
    }else sb.append("1");
    x>>>=1;
  }
sb.reverse().append("\n");
System.out.print(sb);
}
