package com.autoframework.tools;

import com.autoframework.logger.LoggerController;

import java.util.Random;

public class RandomNum {
    final static LoggerController log = LoggerController.getLogger(RandomNum.class);

    //生成三位数的一个随机数
    public static String[] getRandomNumber(int length, int count) {
        Random ran = new Random();
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            String randomNum = "";
            for (int j = 0; j < length; j++) {
                int k = ran.nextInt(10);
                randomNum += k;
            }
            result[i] = randomNum;
        }
        return result;
    }

    public static int getRandomNum(int min,int max){
        Random ran=new Random();
        int num = ran.nextInt(max - min + 1) + min;
        log.info(String.valueOf(num));
        return num;
    }

    public static String getStringRandom(int length){
        String val="";
        Random ran=new Random();

        for (int i=0;i<length;i++){
            String charornum=ran.nextInt(2)%2==0?"char":"num";
            if(charornum.equals("char")){
                int tem = ran.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (ran.nextInt(26) + tem);
            }else {
                val+=ran.nextInt(10);
            }
        }
        log.info(val);
        return val;
    }
}
