//Finds the greatest power of two to be used.
    public static int findBiggerPowerOfTwo(double n){
        if(n<0){return 32;}
        if(n==0){return 0;}
        int power = 1;
        for (int i=0;i<32;i++){
            if (n<1<<power){
                return power-1;
                
            }
            else {
                power++;
            }
        }
        return power;
    }
    
    
        System.out.println(0+":"+(1<<findBiggerPowerOfTwo(0))+":"+findBiggerPowerOfTwo(0));
    System.out.println(1+":"+(1<<findBiggerPowerOfTwo(1))+":"+findBiggerPowerOfTwo(1));
    System.out.println(2+":"+(1<<findBiggerPowerOfTwo(2))+":"+findBiggerPowerOfTwo(2));
    System.out.println(3+":"+(1<<findBiggerPowerOfTwo(3))+":"+findBiggerPowerOfTwo(3));
    System.out.println(4+":"+(1<<findBiggerPowerOfTwo(4))+":"+findBiggerPowerOfTwo(4));
    System.out.println(5+":"+(1<<findBiggerPowerOfTwo(5))+":"+findBiggerPowerOfTwo(5));
    System.out.println(6+":"+(1<<findBiggerPowerOfTwo(6))+":"+findBiggerPowerOfTwo(6));
    System.out.println(7+":"+(1<<findBiggerPowerOfTwo(7))+":"+findBiggerPowerOfTwo(7));
    System.out.println(8+":"+(1<<findBiggerPowerOfTwo(8))+":"+findBiggerPowerOfTwo(8));
