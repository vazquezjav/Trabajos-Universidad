/*****************************************************************************

JEP - Java Math Expression Parser 2.3.1
      January 26 2006
      (c) Copyright 2004, Nathan Funk and Richard Morris
      See LICENSE.txt for license information.

*****************************************************************************/

package org.nfunk.jepexamples;


/**
 * The ThreadTestThread waits for 1 second before calling the evaluate method
 * of the ThreadTest instance.
 * <p>
 * Thanks to Matthew Baird and Daniel Teng for this code.
 */
public class ThreadTestThread extends Thread
{
    ThreadTest test;

    public ThreadTestThread(ThreadTest test_in)
    {
        test = test_in;
    }

    public void run() {
        try {
            Thread.sleep(1);
            test.evaluate();
            Thread.yield();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
