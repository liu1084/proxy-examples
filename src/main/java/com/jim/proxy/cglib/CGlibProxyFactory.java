package com.jim.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by jim on 2017/9/30.
 * This class is ...
 */
public class CGlibProxyFactory implements MethodInterceptor {
    private UserDAO target;

    public CGlibProxyFactory(UserDAO target){
        this.target = target;
    }

    public Object createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        return method.invoke(target, objects);
    }

    public static void main(String[] args) {
        UserDAO target = new UserDAO();
        UserDAO proxy = (UserDAO) new CGlibProxyFactory(target).createProxy();
        proxy.add();
        proxy.delete();
    }
}
