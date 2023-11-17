package com.small.cai.multithread.demo1.lock;

/**
 * @Project: small-multithread-transactional
 * @Author: 张小菜
 * @Description: [ RedisDistributedLock ] 说明： 无
 * @Function: 功能描述： 无
 * @Date: 2023/11/17 017 0:27
 * @Version: v1.0
 */
public class RedisDistributedLock implements DistributedLock{


    private final String lockKey;

    public RedisDistributedLock(String lockName) {
        this.lockKey = "lock:"+lockName;
    }

    @Override
    public void lock() {
        // 使用SETNX设置锁,如果存在则循环获取
    }

    @Override
    public void unLock() {
        // 删除锁key释放锁
    }
}
