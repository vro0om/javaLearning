/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package waitnotify;

import java.util.Scanner;

public class Processor
{
    public void produce() throws InterruptedException
    {
        synchronized (this)
        {
            System.out.println("Producer thread running.....");
            wait();
            System.out.println("Resumed..");
        }
    }
    
    public void consume() throws InterruptedException
    {
        
        Scanner sc =  new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this)
        {
            System.out.println("Waiting.. ");
            sc.nextLine();
            System.out.println("Presed");
            notify();
        }
    }
    
    
}

/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 * 
 * SPPA-T3000
 */
