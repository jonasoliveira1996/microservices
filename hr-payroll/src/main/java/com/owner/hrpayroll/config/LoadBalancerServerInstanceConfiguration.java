package com.owner.hrpayroll.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;

public class LoadBalancerServerInstanceConfiguration {

    public ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new LoadBalancerInstanceSupplier("hr-worker");
    }


}
