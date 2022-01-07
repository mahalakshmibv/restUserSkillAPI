package com.springboot.userskill.restservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.userskill.restservice.exception.ResourceNotFoundException;
import com.springboot.userskill.restservice.model.UserSkillMap;
import com.springboot.userskill.restservice.repository.UserSkillMapRepository;

@RestController
@RequestMapping ("/api")
public class UserSkillMapController {
	
	@Autowired
	private UserSkillMapRepository userSkillMapRepository;
	
	@GetMapping("/userSkillMap")
	public List<UserSkillMap> getAllUserSkillMap(){
		return userSkillMapRepository.findAll();
	}
	
	@GetMapping("/userSkillMap/{userSkillId}")
	public ResponseEntity<UserSkillMap> getAllUserSkillMapById(@PathVariable(value = "userSkillId") String userSkillId ) 
			throws ResourceNotFoundException{
		UserSkillMap userSkillMap = userSkillMapRepository.findById(userSkillId)
				.orElseThrow(() -> new ResourceNotFoundException("User Skill not found for this id :: " + userSkillId));
		return ResponseEntity.ok().body(userSkillMap);  		
	}
	
	@PostMapping("/userSkillMap")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<UserSkillMap> createUserSkillMap(@Validated @RequestBody UserSkillMap userSkillMap) {
		//if(userSkillMapRepository.findById(userSkillMap.getUserSkillId()).isPresent()) {
		//	return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		//}
		return new ResponseEntity<>(userSkillMapRepository.save(userSkillMap), HttpStatus.CREATED);
	}
	
	@PutMapping("/userSkillMap/{userSkillId}")	
	public ResponseEntity<UserSkillMap> updateUserSkillMapDeatils(@PathVariable(value =  "userSkillId") String userSkillId,
			@Validated @RequestBody UserSkillMap userSkillMapDetails)throws ResourceNotFoundException{
		
		UserSkillMap userSkillMap = userSkillMapRepository.findById(userSkillId)
				.orElseThrow(() -> new ResourceNotFoundException("User Skill not found for this id :: " + userSkillId));
		
		userSkillMap.setCreationTime(userSkillMapDetails.creationTime);
		userSkillMap.setLastModTime(userSkillMapDetails.lastModTime);
		userSkillMap.setMonthsOfExp(userSkillMapDetails.monthsOfExp);
		userSkillMap.setSkillId(userSkillMapDetails.skillId);
		userSkillMap.setUserId(userSkillMapDetails.userId);

		final UserSkillMap updatedUserSkillMap = userSkillMapRepository.save(userSkillMap);
		return ResponseEntity.ok(updatedUserSkillMap);		
	}
	
	@DeleteMapping("/userSkillMap/{userSkillId}")
	public Map<String, Boolean> deleteUserSkillMapById(@PathVariable(value =  "userSkillId") String userSkillId)
			throws ResourceNotFoundException{
		
		UserSkillMap userSkillMap = userSkillMapRepository.findById(userSkillId)
				.orElseThrow(() -> new ResourceNotFoundException("User Skill not found for this id :: " + userSkillId));
		userSkillMapRepository.delete(userSkillMap);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	
	}

}
