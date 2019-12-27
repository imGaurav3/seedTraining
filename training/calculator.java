package training;

import java.util.Scanner;

public class calculator{
    public int add(int a,int b){
        return a+b;
    }
    public int sub(int a,int b) {
        return a-b;
    }
    public int mult(int a,int b) {
        return a*b;
    }
    public int div(int a,int b) {
        return a/b;
    }
    public int larg(int a,int b,int c){
        if(a > b && a > c)
            return a;
        else if(b > a && b > c)
            return b;
        else
            return c;
    }
    public void grade(int a){
        if(a >90 && a<=100){
            System.out.println("A");
        }
        else if(a > 80 && a <= 90){
            System.out.println("B");
        }
        else if(a > 70 && a<= 80){
            System.out.println("C");
        }
        else if(a > 60 && a<=70){
            System.out.println("D");
        }
        else if(a > 50 && a<= 60){
            System.out.println("E");
        }
        else{
            System.out.println("F");
        }
    }
    public void mult_table(int a){
        for(int i=1;i<=10;i++){
            System.out.println(a+" * "+i+" = "+(a*i));
        }
    }
    public int prime(int b, int c){
            int i = b;
            int sum = 0;

            while(i <= c){

                int flag = 1;

                for(int j = 2;j<i/2;j++){
                    if(i % j == 0){
                        flag = 0;
                        break;
                    }
                }
                if(flag == 1){
                    sum += i;
                }
                i++;

            }
            return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c1 = sc.nextInt();
        sc.close();

        calculator c = new calculator();

        c.mult_table(a);

        System.out.println("Largest int is: "+c.larg(a,b,c1));
        System.out.print("Grade of student1 is : ");
        c.grade(a);
        System.out.println("Sum of prime between "+b+" and "+c1+" = "+c.prime(b,c1));
        
        // System.out.println(a+" + "+b+" = "+c.add(a,b));
        // System.out.println(a+" - "+b+" = "+c.sub(a,b));
        // System.out.println(a+" * "+b+" = "+c.mult(a,b));
        // System.out.println(a+" / "+b+" = "+c.div(a,b));
    }
}