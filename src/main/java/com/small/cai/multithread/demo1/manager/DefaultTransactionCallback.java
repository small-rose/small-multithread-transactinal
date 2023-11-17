package com.small.cai.multithread.demo1.manager;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: small-multithread-transactional
 * @Author: 张小菜
 * @Description: [ DefaultTransactionCallback ] 说明： 无
 * @Function: 功能描述： 无
 * @Date: 2023/11/17 017 0:38
 * @Version: v1.0
 */
@Slf4j
public class DefaultTransactionCallback implements TransactionCallback{


    private DistributedTransactionManager.Transaction transaction;

    public DefaultTransactionCallback(DistributedTransactionManager.Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void run() {

        // 执行回滚逻辑
        transaction.rollback(this);

        // 打印回滚日志
        log.info("Transaction rolled back");

    }

}
