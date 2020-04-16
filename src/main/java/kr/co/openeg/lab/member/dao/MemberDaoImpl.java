package kr.co.openeg.lab.member.dao;

import kr.co.openeg.lab.member.dao.MemberDao;
import kr.co.openeg.lab.member.model.MemberModel;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl  implements MemberDao{

	@Autowired
	SqlSessionTemplate ss;
	
	public void insertMember(MemberModel memberModel) {
		ss.insert("member.addMember", memberModel);
		
	}

	
	public MemberModel selectMember(String userId) {
		return ss.selectOne("member.findByUserId", userId);
		
	}

	
	public void deleteMember(MemberModel memberModel) {
		// TODO Auto-generated method stub
		ss.delete("member.deleteMember", memberModel);
	}

	
	public void updateMember(MemberModel memberModel) {
		// TODO Auto-generated method stub
		ss.update("member.updateMember", memberModel);
		
	}

}
