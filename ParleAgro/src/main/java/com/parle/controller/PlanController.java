package com.parle.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parle.model.Plan;
import com.parle.service.PlanService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*",allowedHeaders="*")
public class PlanController {
	
	@Autowired
	PlanService planService;
	
	@PostMapping("/saveplan")
	ResponseEntity<String> createPlan(@Validated @RequestBody Plan plan) throws URISyntaxException {
		String result = planService.savePlan(plan);
		if(result.equals("Success")) {
			return ResponseEntity.ok().body(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
				
	}

}
