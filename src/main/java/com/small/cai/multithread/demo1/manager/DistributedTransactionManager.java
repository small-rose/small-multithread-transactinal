package com.small.cai.multithread.demo1.manager;

import com.small.cai.multithread.demo1.lock.DbDistributedLock;
import com.small.cai.multithread.demo1.lock.DistributedLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Project: small-multithread-transactional
 * @Author: 张小菜
 * @Description: [ DistributedTransactionManager ] 说明： 无
 * @Function: 功能描述： 无
 * @Date: 2023/11/17 017 0:30
 * @Version: v1.0
 */
public class DistributedTransactionManager {

    private enum Phase {
        INIT,
        PREPARED,
        COMMITTING,
        COMMITTED,
        ROLLING_BACK,
        ROLLED_BACK
    }

    private final AtomicReference<Phase> phase = new AtomicReference<>(Phase.INIT);

    private final DistributedLock lock = new DbDistributedLock("tx");

    public Transaction begin() {
        lock.lock();
        return new Transaction();
    }

    class Transaction {

        private boolean prepared;

        public void prepare() {
            prepared = true;
            phase.compareAndSet(Phase.INIT, Phase.PREPARED);
        }

        public void commit() {
            if (prepared && phase.compareAndSet(Phase.PREPARED, Phase.COMMITTED)) {
                // committing
                lock.unLock();
            }
        }

        public void rollback(TransactionCallback callback) {
            if (phase.compareAndSet(Phase.INIT, Phase.ROLLING_BACK)) {
                callback.run();
                phase.set(Phase.ROLLED_BACK);
            }
        }
    }
}
