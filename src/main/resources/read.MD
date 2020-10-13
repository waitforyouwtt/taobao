限流的方式：

1.基于 guawa的三种限流方式: IndexController  
   :tryAcquire方法和JDK的lock的使用形式上看有异曲同工之妙，即请求到这里，如果不满足要求立即返回结果，
         这样客户端就不用排队等待了。
         在测试的时候发现，当输入参数为4，并且两个连续的请求之间相隔短暂的时间时，请求依然可以成功，
         这是因为在Guawa的令牌桶的设计中，有一个很有趣的概念叫做排队机制，即当前的这次请求如果失败了，底层会将这次请求的信息入队，下一次请求的时候优先处理，
         所以就出现了上面描述的现象。
         
    //非阻塞式限流
    //http://localhost:8083/tryAcquire?count=1
    //http://localhost:8083/tryAcquire?count=2
    //http://localhost:8083/tryAcquire?count=4
    
总结：Guawa的使用还是比较简单的，如果自己的项目无需做分布式部署，而且只是对部分的接口做限流的时候可以考虑使用Guawa来做   

2.基于gateway网关实现限流 
