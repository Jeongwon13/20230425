package edu.kh.comm.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.comm.member.model.vo.Member;

@Repository // 영속성을 가지는 DB/파일과 연결되는 클래스임을 명시 + bean으로 등록한다.
public class MemberDAO {

	/*
	 * DAO는 DB랑 연결하기 위한 Connection이 공통적으로 필요하다!
	 * -> 필드에 선언할거야
	 * 
	 *  + Mybatis 영속성 프레임워크를 통해서 이용하려면 Connection을 이용해 만든 객체
	 *  SqlSessionTemplate을 사용
	 * 
	 */
	
	@Autowired // root-context.xml에서 생성된 SqlSessionTemplate bean을 의존성 주입(DI)
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(MemberDAO.class);
	
	public Member login(Member inputMember) {
		
		// 1행 조회(파라미터 X) 방법
		//int count = sqlSession.selectOne("namespace값.id값");
		//int count = sqlSession.selectOne("memberMapper.test1");
		//logger.debug(count + ""); // 쌍따옴표로 문자열 형태로 만들어라
		
		// 1행 조회(파라미터 O) 방법
		String memberNickname = sqlSession.selectOne("memberMapper.test2", inputMember.getMemberEmail());
		logger.debug(memberNickname);
		
		return null;
	}
	
	
	
}
