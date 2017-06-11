package com.party.ijurong.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Copyright ©, 2016-2056
 * FileName:  SpringContextUtil
 *
 * @author CS-711701-00027
 * @version 1.0
 * @Date: 2017/4/21
 * Description:
 * Function List:
 * 1. -------
 * History:
 * maurice 16/02/12 1.0 build this moudle
 */
@Component
public class SpringContextUtil  implements ApplicationContextAware {

    // Spring应用上下文环境
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     */
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象 这里重写了bean方法，起主要作用
     */
    public static Object getBean(String beanId) throws BeansException {
        return applicationContext.getBean(beanId);
    }
}