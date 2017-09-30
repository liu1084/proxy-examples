package com.jim.proxy.staticProxy;

/**
 * Created by jim on 2017/9/30.
 * 代理类
 */
public class StaticUser implements IStaticUser {

    private IStaticUser target;

    public StaticUser(IStaticUser target){
        this.target = target;
    }

    public void delete() {
        target.delete();
    }

    public void add() {
        target.add();
    }

    public void login() {
        target.login();
    }
}
