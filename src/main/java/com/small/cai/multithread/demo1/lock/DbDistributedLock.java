package com.small.cai.multithread.demo1.lock;

/**
 * @Project: small-multithread-transactional
 * @Author: 张小菜
 * @Description: [ DbDistributedLock ] 说明： 无
 * @Function: 功能描述： 无
 * @Date: 2023/11/17 017 0:27
 * @Version: v1.0
 */
public class DbDistributedLock implements DistributedLock{

    private final String lockName;

    public DbDistributedLock(String lockName) {
        this.lockName = lockName;
    }


    @Override
    public void lock() {

    }

    @Override
    public void unLock() {

    }
}
