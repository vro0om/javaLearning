/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package zzzz_practive;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer
{
    
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    
    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Runnable()
        {
            
            @Override
            public void run()
            {
                try
                {
                    producer();
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    
                }
                
            }
        });
        Thread t2 = new Thread(new Runnable()
        {
            
            @Override
            public void run()
            {
                try
                {
                    consumer();
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    
                }
                
            }
        });
        
        
        t1.start();
        t2.start();
        
        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            
        }
    }
    
    private static void producer() throws InterruptedException
    {
        Random rand = new Random();
        
        while (true)
        {
            queue.put(rand.nextInt(100));
            
        }
    }
    
    private static void consumer() throws InterruptedException
    {
        Random r = new Random();
        while (true)
        {
            Thread.sleep(100);
            if (r.nextInt(10)==0)
            {
                Integer value = queue.take();
                
                System.out.println("Taken : "+value+" Queue size "+ queue.size() );
            }
            
        }
        
    }
}

/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 * 
 * SPPA-T3000
 */
