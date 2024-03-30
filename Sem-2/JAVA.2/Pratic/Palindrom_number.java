// import java.util.*;
class Solution {
    public boolean Palindrome_number(int x) {
        int rev=0;
        // System.out.println("Enter  teh value ogf x:");
        // int x=sc.nextInt();
        if(x<0){
            // System.out.println("false");
            return false;
        }
        int temp=x;
        while(temp!=0)
        {
            int digit=(int)(temp%10);
            rev=(rev*10)+digit;
            temp/=10;
        }
        // System.out.println(rev);
        return (rev==x);
    }
}