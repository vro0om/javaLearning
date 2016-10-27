/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package zzzz_practive;

import java.util.Arrays;

public class CrapTester
{
//    public static void main(String[] args)
//    {
//        byte[] b = { 12, 12 };
//        
//        int byteIndex = 0;
//        System.out.println((((b[byteIndex] & 0xFF) << 8) | (b[byteIndex + 1] & 0xFF)));
//        System.out.println((((b[byteIndex++] & 0xFF) << 8) | (b[byteIndex] & 0xFF)));
//        System.out.println(Arrays.asList(b));
//    }
    
    public static void main(String[] args) throws InterruptedException
    
    {
//       new CrapTester().abc(null);
       
//       A a= new A();
       B b = new B();
//       A c = new B();
//       
//       
//       a.display();
//       b.display();
//       c.toString();
     }
    
    void abc(String s)
    {System.out.println(s);}
    
    void abc(int s)
    {System.out.println(s);}
    
   
}

class A
{
    A()
    {
        System.out.println("A");
    }
    
    void display(){
        System.out.println("In A");
    }
}

class B extends A
{
    
    
    B()
    {
        super();
        System.out.println("B");
    }
    void display(){
        System.out.println("In B");
    }
    
     public String toString() 
    {
        System.out.println("I am B");
        return new String();
    }
}




/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 * 
 * SPPA-T3000
 */
