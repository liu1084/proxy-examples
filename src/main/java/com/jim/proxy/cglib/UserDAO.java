package com.jim.proxy.cglib;

import com.jim.proxy.IUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jim on 2017/9/30.
 * This class is ...
 */
public class UserDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);
    private IUser user;
    public final void add(){
        LOGGER.debug(this.getClass().getName() + "-> add");

    }
    public void delete(){
        LOGGER.debug(this.getClass().getName() + "-> delete");
    }
}
