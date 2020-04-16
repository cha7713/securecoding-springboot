package kr.co.openeg.lab.login.dao;

import kr.co.openeg.lab.login.dao.LoginDao;
import kr.co.openeg.lab.login.model.LoginSessionModel;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	SqlSessionTemplate ss;

	public LoginSessionModel selectUserId(String userId) {
		return ss.selectOne("login.loginCheck1\", userId");
		

	}	
	
	public LoginSessionModel selectUserId(String userId, String userPw) {
	return	ss.selectOne("login.loginCheck2", new LoginSessionModel(userId, userPw, null, false));
	}	
}
