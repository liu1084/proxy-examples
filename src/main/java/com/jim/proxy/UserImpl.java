package com.jim.proxy;

import com.jim.proxy.staticProxy.IStaticUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jim on 2017/9/30.
 * 被代理的类
 */
public class UserImpl implements  IUser, IStaticUser {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserImpl.class);

    public void add() {
        LOGGER.debug(this.getClass().getName() + "add");
    }

    public void delete() {
        LOGGER.debug(this.getClass().getName() + "delete");
    }

    public void login() {
        LOGGER.debug(this.getClass().getName() + "login");
    }
}
