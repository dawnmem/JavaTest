package com.junit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.junit.testCode;

public class testJunit 
{
    /**
     * Rigorous Test :-)
     */
    testCode cal=new testCode();
    static int arr[]={11,1,2,3,1,4,5,6,9,0,2,-1};
    static int _arr[];
    static int __arr[];

    @BeforeClass
    public static void setUP() throws Exception {
        _arr=(int[])arr.clone();
        Arrays.sort(_arr);
    }
    
    @Before 
    public void _setUp() throws Exception { 
        __arr=(int[])arr.clone();
    }
    
    @Test(timeout = 5000)
    public void testCrsort(){
        cal.sort(__arr, "cr");
        for(int i=0;i<arr.length;i++)
            assertEquals(_arr[i],__arr[i]);
    }

    @Test(timeout = 5000)
    public void testXesort(){
        cal.sort(__arr, "xe");
        for(int i=0;i<arr.length;i++)
            assertEquals(_arr[i],__arr[i]);
    }

    @Test(timeout = 5000)
    public void testKssort(){
        cal.sort(__arr, "ks");
        for(int i=0;i<arr.length;i++)
            assertEquals(_arr[i],__arr[i]);
    }

    @Test(timeout = 5000)
    public void testGbsort(){
        cal.sort(__arr, "gb");
        for(int i=0;i<arr.length;i++)
            assertEquals(_arr[i],__arr[i]);
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
}
