/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.util;

import java.util.Random;

/**
 * @author tjwang
 * @version $Id: RandomUtil.java, v 0.1 2017/5/19 0019 16:48 tjwang Exp $
 */
public class RandomUtil {

    /**
     * 获取0-max（包含）的随机数
     *
     * @param max
     * @return
     */
    public static int getRandom(int max) {
        int min = 0;
        return getRandom(min, max);
    }

    /**
     * 获取 [min-max] 之间的随机数
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max) {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    public static void main(String[] args) {
        int min = 0;
        int max = 10;
        while (true) {
            int num = getRandom(min, max);
            System.out.println(num);
            if (num < min || num > max) {
                throw new RuntimeException("过界");
            }
        }

    }

}
