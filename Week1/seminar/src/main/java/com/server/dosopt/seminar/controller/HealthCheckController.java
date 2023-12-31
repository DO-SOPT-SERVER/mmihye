package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.dto.HealthCheckResponse;
import com.server.dosopt.seminar.dto.StatusEnum;
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

//    {
//        "status": "OK"
//    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("ok");
    }

    // OK

    @GetMapping("/v3")
    public String healthCheckV3(){

        // 빌더 패턴
        Person person = Person.builder()
                .lastName("최")
                .firstName("윤한")
                .build();

        return "OK";
    }

    // OK

    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheckV4() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

//    {
//        "status": "OK"
//    }

//    @GetMapping("/v5")
//        public ResponseEntity<HealthCheckResponse> healthCheckV5(){
//            return ResponseEntity.ok(new HealthCheckResponse());
//        }

//    {
//        "status": "OK"
//    }

    @GetMapping("/v6")
    public ResponseEntity<HealthCheckResponse> healthCheckV6(){
        return ResponseEntity.ok(new HealthCheckResponse(StatusEnum.OK));
    }

//    {
//        "code": 200,
//            "status": "OK",
//            "success": true
//    }
}
