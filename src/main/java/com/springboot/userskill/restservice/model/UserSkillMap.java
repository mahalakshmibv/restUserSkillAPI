package com.springboot.userskill.restservice.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.springboot.userskill.restservice.generator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "tbl_lms_userskill_map")
public class UserSkillMap {

	public UserSkillMap() {
		super();
	}

	public UserSkillMap(String userId, long skillId, BigDecimal monthsOfExp, Date creationTime, Date lastModTime) {
		super();

		this.userId = userId;
		this.skillId = skillId;
		this.monthsOfExp = monthsOfExp;
		this.creationTime = creationTime;
		this.lastModTime = lastModTime;
	}

	@Id
	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_skill_id")
    @GenericGenerator(
            name = "user_skill_id", 
            strategy = "com.springboot.userskill.restservice.generator.StringPrefixedSequenceIdGenerator", 
            parameters = { 
            		 //@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                     @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "US"),
                     @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%d")})

	//@GenericGenerator(name = "assigned-userSkill", strategy = "com.springboot.userskill.restservice.generator.UserSkillMapIdGenerator")
	//@GeneratedValue(generator = "assigned-userSkill", strategy = GenerationType.IDENTITY)
	@Column(name="user_skill_id")
	public String userSkillId;
	
	@Column(name="user_id")
	public String userId;
	
	@Column(name="skill_id")
	public long skillId;
	
	@Column(name="months_of_exp")
	public BigDecimal monthsOfExp;
	
	@Column(name="creation_time")
	public Date creationTime;
	
	@Column(name="last_mod_time")
	public Date lastModTime;

	public String getUserSkillId() {
		return userSkillId;
	}

	public void setUserSkillId(String userSkillId) {
		this.userSkillId = userSkillId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public BigDecimal getMonthsOfExp() {
		return monthsOfExp;
	}

	public void setMonthsOfExp(BigDecimal monthsOfExp) {
		this.monthsOfExp = monthsOfExp;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastModTime() {
		return lastModTime;
	}

	public void setLastModTime(Date lastModTime) {
		this.lastModTime = lastModTime;
	}

}
