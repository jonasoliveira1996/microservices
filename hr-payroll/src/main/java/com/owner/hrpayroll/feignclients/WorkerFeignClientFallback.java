package com.owner.hrpayroll.feignclients;

import com.owner.hrpayroll.entites.Worker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkerFeignClientFallback implements WorkerFeignClient{
    @Override
    public ResponseEntity<Worker> findById(Long id) {
        Worker worker = new Worker(1L, "CircuitBreaker Fallback", 0.0);
        return ResponseEntity.ok(worker);
    }
}
