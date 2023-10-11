package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.dto.HealthCheckResponse;
import com.server.dosopt.seminar.sample.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/v1")
    public Map<String,String> healthCheck(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/v3")
    public String healthCheckV3(){

        // 빌더 패턴
        Person person = Person.builder()
                .lastName("최")
                .firstName("윤한")
                .build();

        return "OK";
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheckV4() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
        public ResponseEntity<HealthCheckResponse> healthCheckV5(){
            return ResponseEntity.ok(new HealthCheckResponse());
        }

}
