/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package zzzz_practive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

 class Processor implements Runnable
{
    
    private int id;

    public Processor(int id)
    {
        this.id = id;
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void run()
    {
       System.out.println("Starting : "+id);
       try
    {
        Thread.sleep(5000);
    }
    catch (InterruptedException e)
    {
        // TODO Auto-generated catch block
        
    } 
       System.out.println("Stopping : "+id);
    }
    
}


public class Executors1
{
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++)
        {
            ex.submit(new Processor(i));
            if (i>3)
            {
                
            }
        }
        ex.shutdown();
        
        System.out.println("Submited");
        
        ex.awaitTermination(1, TimeUnit.DAYS);
        System.err.println("All es completed");
    }
}

/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * SPPA-T3000
 */
