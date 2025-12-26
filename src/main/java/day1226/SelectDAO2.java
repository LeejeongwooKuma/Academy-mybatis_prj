package day1226;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class SelectDAO2 {
	private static SelectDAO2 sDAO;
	
	private SelectDAO2() {
		
	}
	public static SelectDAO2 getInstance() {
		if( sDAO == null) {
			sDAO=new SelectDAO2();
		}//end if
		return sDAO;
	}//getInstance
	
	/**
	 * 사원번호와 부서번호에대한 사원 정보 조회
	 * @param empDTO
	 * @return
	 * @throws PersistenceException
	 */
	public EmpDomain useDomain(EmpDTO empDTO) throws PersistenceException{
		EmpDomain empDomain=null;
		
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
		empDomain=ss.selectOne("day1226.useDomain",empDTO);
		if( ss != null ) { ss.close(); }//end if
		return empDomain;
	}//useDomain
	
	
	public List<ZipcodeDomain> useLike(String dong) throws PersistenceException{
		List<ZipcodeDomain> zipList=null;
		
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
		zipList=ss.selectList("day1226.like",dong);
		if( ss != null ) { ss.close(); }//end if
		return zipList;
	}//useLike
	
	public List<EmpDomain> lessThan(int sal) throws PersistenceException{
		List<EmpDomain> empList=null;
		
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
		empList=ss.selectList("day1226.lessThan",sal);
		if( ss != null ) { ss.close(); }//end if
		return empList;
	}//useDomain
	
	public List<EmpDomain> greaterThan(int sal) throws PersistenceException{
		List<EmpDomain> empList=null;
		
		SqlSession ss = MyBatisHandler.getInstance().getMyBatisHandler(true);
		empList=ss.selectList("day1226.greaterThan",sal);
		if( ss != null ) { ss.close(); }//end if
		return empList;
	}//useDomain
	
}//class
