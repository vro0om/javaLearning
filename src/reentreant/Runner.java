/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package reentreant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner
{
    int count = 0;
    
    private Lock lock = new ReentrantLock();
    
    private void increment()
    {
        for (int i = 0; i < 10000; i++)
        {
            count++;
        }
        
    }
    
    public void firstThread()
    {
        lock.lock();
        try
        {
            increment();
            
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
        finally
        {
            
            lock.unlock();
        }
    }
    
    public void secondThread()
    {
        
        lock.lock();
        try
        {
            increment();
            
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
        finally
        {
            
            lock.unlock();
        }
        // TODO Auto-generated method stub
        
    }
    
    public void finished()
    {
        System.out.println(count);
        
    }
}

/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 * 
 * SPPA-T3000
 */
