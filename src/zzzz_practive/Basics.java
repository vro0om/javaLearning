/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package zzzz_practive;

public class Basics
{
    
    public Basics()
    {
        Integer  n  = 8 ;
        
        increment(n);
        System.out.println(n);
    }
    private void increment(Integer n)
    {
        n +=1;
        System.out.println(n);
        
    }
    public static void main(String[] args)
    {
        new Basics();
    }
}


class ModifyMe
{
    private String name;
    private int age;
    private int roll;
    
    public ModifyMe(String name, int age, int roll)
    {
        this.name = name;
        this.age = age;
        this.roll = roll;
        
    }
    
    
    @Override
    public int hashCode()
    {
        
        return super.hashCode();
    }
    
    
    
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * SPPA-T3000
 */
