package com.test;

import com.hackerspace.dao.Studio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by tianx on 2016/3/1.
 */
public class LogTest {

    public static void main(String[] args) {



        Logger logger = LoggerFactory.getLogger(Studio.class);

        logger.info("Hello World");


    }
}
