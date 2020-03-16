package com.sykean.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author ${yanghong}
 * @create 2020/3/12 14:37
 */
public interface LoadBalanced {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
