package com.springboot.userskill.restservice.generator;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.springboot.userskill.restservice.model.UserSkillMap;

public class UserSkillMapIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub		
		
		 if (object instanceof UserSkillMap) {
			 UserSkillMap userSkillMap = (UserSkillMap) object;
	            String userId = userSkillMap.getUserId().toString();
	            Serializable id = userId.substring(0, 1) + "S" + userId.substring(1);
	            if (id != null) {
	                return id;
	            }
	        }
		
	
		 return null;
	}

}
