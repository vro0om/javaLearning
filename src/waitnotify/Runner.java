/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package waitnotify;

public class Runner
{
    public static void main(String[] args) throws InterruptedException
    {
        final    ProcessorCP p = new ProcessorCP();
        Thread t1 = new Thread(new Runnable()
        {
            
            @Override
            public void run()
            {
                try
                {
                    p.produce();
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
                    p.consume();
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    
                }
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * SPPA-T3000
 */
