/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package waitnotify;

import java.util.LinkedList;
import java.util.Random;

import org.w3c.dom.ls.LSInput;

public class ProcessorCP
{
    
    private LinkedList<Integer> list = new LinkedList<Integer>();
    
    private final int LIMIT = 10;
    
    private Object lock = new Object();
    
    public void produce() throws InterruptedException
    {
        
        int value = 0;
        while (true)
        {
            synchronized (lock)
            {
                
                while (list.size() == LIMIT)
                {
                    lock.wait();
                }
                list.add(value++);
                
            }
            
        }
    }
    
    public void consume() throws InterruptedException
    {
        Random random = new Random();
        while (true)
        {
            
            synchronized (lock)
            {
                
                while (list.size() == 0)
                {
                    lock.wait();
                    
                }
                System.out.print("List Size : " + list.size());
                int value = list.removeFirst();
                System.out.println(" ; value is : " + value);
                lock.notify();
            }
            
            Thread.sleep(random.nextInt(1000));
        }
        
        
    }
}

/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 * 
 * SPPA-T3000
 */
