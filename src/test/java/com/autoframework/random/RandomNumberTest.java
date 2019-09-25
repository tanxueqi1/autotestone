package com.autoframework.random;

import com.autoframework.tools.RandomNum;
import org.testng.annotations.Test;

public class RandomNumberTest {


    @Test
    public void test(){
        int num = RandomNum.getRandomNum(3, 5);
        System.out.println(num);
    }

    @Test
    public void test1(){
        System.out.println( RandomNum.getStringRandom(3));

    }
}
