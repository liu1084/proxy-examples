package com.jim.proxy.jdk;

import com.jim.proxy.IUser;
import com.jim.proxy.UserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jim on 2017/9/30.
 * This class is ...
 */
public class JDKProxyFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(JDKProxyFactory.class);
    private Object target;

    public JDKProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(target, args);
                    }
                }
        );
    }

    public static void main(String[] args) {
        // 目标对象
        IUser target = new UserImpl();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        LOGGER.debug(target.getClass().getName());

        // 给目标对象，创建代理对象
        IUser proxy = (IUser) new JDKProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        LOGGER.debug(proxy.getClass().getName());

        // 执行方法   【代理对象】
        proxy.add();
    }
}
