/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package reentreant;


public class Mian
{
    public static void main(String[] args) throws InterruptedException
    {
        final Runner p = new Runner();
        Thread t1 = new Thread(new Runnable()
        {
            
            @Override
            public void run()
            {
                p.firstThread();
            }
        });
        
        Thread t2 = new Thread(new Runnable()
        
        {
            
            @Override
            public void run()
            {
                p.secondThread();
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        p.finished();
    }
}

/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 * 
 * SPPA-T3000
 */
