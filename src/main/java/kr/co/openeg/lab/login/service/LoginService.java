package kr.co.openeg.lab.login.service;

import javax.annotation.Resource;

import kr.co.openeg.lab.login.dao.LoginDao;
import kr.co.openeg.lab.login.dao.LoginDaoImpl;
import kr.co.openeg.lab.login.model.LoginSessionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	LoginDaoImpl dao;
	
	public LoginSessionModel checkUserId(String userId) {
		return dao.selectUserId(userId);		
	}	

	public LoginSessionModel checkUserId(String userId, String userPw) {
		return dao.selectUserId(userId, userPw);
	}	
}
