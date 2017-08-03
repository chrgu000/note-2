package com.company.niuke;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by a1996_000 on 2017/8/1.
 */
//单例模式
public class Single {
    static Single single = null;
    private Single(){}
    static Lock lock = new ReentrantLock();
    public static Single getSingle(){
        lock.lock();
        if(single==null){
            single = new Single();
        }
        lock.unlock();
        return single;
    }

}
