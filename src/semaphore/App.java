/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED.
 *
 * SPPA-T3000  
 * 
 */

package semaphore;

import java.util.concurrent.Semaphore;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        
        
        Semaphore sem = new Semaphore(1);
//        sem.release();
        sem.acquire();
        System.out.println(sem.availablePermits());
        sem.acquire();
        System.out.println(sem.availablePermits());
    }
}


/*
 * Copyright (c) Siemens AG 2016 ALL RIGHTS RESERVED
 *
 * SPPA-T3000
 */
