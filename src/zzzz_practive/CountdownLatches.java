/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package zzzz_practive;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CProcessor implements Runnable{

    private CountDownLatch latch;

    public CProcessor(CountDownLatch latch)
    {
        this.latch = latch;
    }
    
    @Override
    public void run()
    {
        System.out.println("Started   ");
        
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            
        }
        
        latch.countDown();
        
    }
    
}






public class CountdownLatches
{
    public static void main(String[] args)
    {
        CountDownLatch latch = new CountDownLatch(3);
        
        ExecutorService ex = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 3; i++)
        {
            ex.submit(new CProcessor(latch));
        }
        
        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            
            
        }
        
        System.out.println("Completyed");
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * SPPA-T3000
 */
