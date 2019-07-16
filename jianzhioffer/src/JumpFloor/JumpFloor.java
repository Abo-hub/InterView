package JumpFloor;

import java.util.Scanner;

public class JumpFloor {

    //方法一 O(2^N)
    public int jumpFloor1(int target) {
        if(target<1)
            return 0;
        if(target == 1 || target == 2)
            return target;
        
        return jumpFloor1(target-1)+jumpFloor1(target-2);
    } 

    //方法二 O(N) 
    public int jumpFloor2(int target){
    
        if(target < 1)
            return 0;
        if(target == 1 || target == 2)
            return target;
        int res = 2;
        int pre = 1;
        int tmp = 0;
        for(int i = 3;i<=target;i++){
            tmp = res;
            res = tmp + pre;
            pre = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        JumpFloor jf = new JumpFloor();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(jf.jumpFloor1(n));
        System.out.println(jf.jumpFloor2(n));
      
    }
}