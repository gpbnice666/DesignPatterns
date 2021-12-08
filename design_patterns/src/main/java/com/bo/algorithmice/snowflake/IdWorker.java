package com.bo.algorithmice.snowflake;

/**
 * @author gpb
 * @date 2021/10/19 17:08
 */
public class IdWorker {

    /* 因为二进制里第一位bit 为1 那么都是负数，但是我们生成的id 都是正数，所以第一个bit统一都是0 */

    /**
     * 机器ID 二进制5位 32位-1位 31个
     */
    private long workerId;

    /**
     * 机房ID 二进制5位 32位-1位 31个
     */
    private long datacenterId;

    /**
     * 代表一毫秒内生成的多个id的最新序号  12位 4096 -1 = 4095 个
     */
    private long sequence;

    /**
     *   设置一个时间初始值    2^41 - 1   差不多可以用69年 = 1585644268888L
     */
    private  long twepoch = 2 ^ 41 - 1;

    /**
     * 5位 的机器id
     */
    private long workerIdBits = 5l;

    /**
     * 5位 的机器id
     */
    private long datacenterIdBits = 5l;

    /**
     * 每毫秒内产生的id数 2 的 12次方
     */
    private long sequenceBits = 12l;

    /**
     * 这个是二进制运算，就是5 bit最多只能有31个数字，也就是说机器id最多只能是32以内
     */
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /**
     * 这个是一个意思，就是5 bit最多只能有31个数字，机房id最多只能是32以内
     */
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    private long workerIdShift = sequenceBits;

    private long datacenterIdShift = sequenceBits + workerIdBits;

    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * 记录产生时间毫秒数，判断是否是同1毫秒
     */
    private long lastTimestamp = -1L;

    public long getWorkerId(){
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getTimestamp() {
        return System.currentTimeMillis();
    }


    public IdWorker(long workerId, long datacenterId, long sequence){
        // 检查机房id和机器id 是否超过31  不能小于
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0",maxWorkerId));
        }
        if (datacenterId > maxWorkerId || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenterId Id can't be greater than %d or less than 0",maxWorkerId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

    /**
     * 核心方法
     * @return id 生成id
     */
    public synchronized long nextId(){
        // 获取当前时间戳
        long timestamp = getTime();

        if(timestamp < lastTimestamp){
            System.err.printf(
                    "clock is moving backwards. Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(
                    String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
                            lastTimestamp - timestamp));
        }

        // 下面是说假设在同一个毫秒内，又发送一个请求生成一个id
        // 这个时候就的吧seqence序号给递增1 最多就是4096
        if ( lastTimestamp == timestamp){
            // 说明一个毫秒内最好只能又4096个数字 无论你传递多少进来
            // 这个位运算保证始终就是在4096这个范围内，避免你自己传递个sequence超过了4096这个范围
            sequence = (sequence + 1) & sequenceMask;

            // 当某一毫秒的时间 产生的id数 超过 4095 系统会进入等待 值到下一毫秒 系统继续产生id
            if(sequence == 0){
                timestamp = tilNextMillis(lastTimestamp);
            }
        }else {
            sequence = 0;
        }

        // 记录一下最近一次生成id的时间戳
        lastTimestamp = timestamp;
      /**
        这最核心的二进制位运算 生成一个64bit
         先将当前时间戳 左移 放到 41bit位那 将机房id左移5bit那，将机器id 左移 5bit位
         将序号方最后12bit位
         最后拼接起来生成一个 64bit 的二进制数字 转换成10进制就是 long 类
       */
        return ( (timestamp - timestamp) << timestampLeftShift ) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) | sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = getTime();
        while ((timestamp <= lastTimestamp)) {
            timestamp = getTime();
        }
        return timestamp;
    }

    /**
     * 获取当前时间戳
     * @return
     */
    public long getTime(){
        return System.currentTimeMillis();
    }


    public static void main(String[] args) {
        System.out.println(1&4596);
        System.out.println(2&4596);
        System.out.println(6&4596);
        System.out.println(6&4596);
        System.out.println(6&4596);
        System.out.println(6&4596);
        System.out.println("**************************");
		IdWorker worker = new IdWorker(1,1,1);
		for (int i = 0; i < 10000; i++) {
			System.out.println(worker.nextId());
		}
    }

}
