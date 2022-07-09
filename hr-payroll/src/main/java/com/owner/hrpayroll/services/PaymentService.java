package com.owner.hrpayroll.services;

import com.owner.hrpayroll.config.LoadBalancerServerInstanceConfiguration;
import com.owner.hrpayroll.entites.Payment;
import com.owner.hrpayroll.entites.Worker;
import com.owner.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workerId, int days) {
        System.out.println("ANTES************");
        LoadBalancerServerInstanceConfiguration lb = new LoadBalancerServerInstanceConfiguration();
        lb.serviceInstanceListSupplier().get().toStream().forEach(System.out::println);
        Worker worker = workerFeignClient.findById(workerId).getBody();
        System.out.println("DEPOIS************");
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}

