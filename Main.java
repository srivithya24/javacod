import java.util.*;
class Main{
    public static void main(String[] args)
    {
        char ch=' ';
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        if(input.length()==1)   {
            ch=input.charAt(0);
            if((ch>='a' && ch<='z') ||(ch>='A' && ch<='Z')){
               System.out.println("int:" +(int)ch);
               System.out.println("float:" +(float)ch);
               System.out.println("byte:" +(byte)ch);
               System.out.println("short:" +(short)ch);
            }
            else{
                System.out.println("Invalid");
            }
        }
        else{
            System.out.println("Invalid");
        }
    }
}
