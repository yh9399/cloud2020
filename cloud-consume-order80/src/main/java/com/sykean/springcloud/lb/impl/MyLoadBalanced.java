package com.sykean.springcloud.lb.impl;

import com.sykean.springcloud.lb.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author ${yanghong}
 * @create 2020/3/12 14:40
 */
@Component
public class MyLoadBalanced implements LoadBalanced {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    /**
     * 获取访问次数，atomicInteger从0开始，所以第一次访问时current为0.0< 2147483647.所以next=current+1=1.
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current >= 2147483647 ? 0: current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("********第几次访问,次数next:"+next);
        return  next;
    }

    /**
     * 返回访问服务器对应下标
     * @param serviceInstances
     * @return
     */
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        //服务器实例是固定的
        int index=getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
