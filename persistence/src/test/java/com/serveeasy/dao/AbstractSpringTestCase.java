package com.serveeasy.dao;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: cristian.popovici
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/serveeasy/context/applicationContext.xml"})
public abstract class AbstractSpringTestCase implements ApplicationContextAware {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationContext context;

    public final void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return context;
    }

    protected Logger getLog() {
        return logger;
    }
}
