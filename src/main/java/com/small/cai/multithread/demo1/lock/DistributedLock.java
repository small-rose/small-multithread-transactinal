package com.small.cai.multithread.demo1.lock;

/**
 * @Project: small-multithread-transactional
 * @Author: 张小菜
 * @Description: [ DistributedLock ] 接口说明： 无
 * @Function: 功能描述： 无
 * @Date: 2023/11/17 017 0:27
 * @Version: v1.0
 */
public interface DistributedLock {

    public void lock();

    public void unLock();
}
