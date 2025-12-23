package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHandler {
	private static MyBatisHandler mbh;
	private static SqlSessionFactory ssf;
	
	private MyBatisHandler() {
		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
	}
	
	public static MyBatisHandler getInstance() {
		if(mbh==null) {
			mbh=new MyBatisHandler();
		}//end if
		return mbh;
	}//getInstance
	
	private static SqlSessionFactory getSessionFactory() throws IOException{//Reader때메 IOException 필요
		if( ssf == null ) {
			//1. 설정용 XML과 연결
			Reader reader=Resources.getResourceAsReader("kr/co/sist/dao/mybatis-config.xml");
			//2. SqlSessionFactoryBuild 생성
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			//3. SqlSessionFactory를 building 한다.
			ssf = ssfb.build(reader);
			
			if( reader != null) {
				reader.close();
			}//end if
		}//end if
		return ssf;
	}//getSessFactory
	
	/**
	 * MyBatis Handler 얻기
	 * @param autoCommitFlag true-autocommit, false - non autocommit
	 * @return
	 */
	public SqlSession getMyBatisHandler( boolean autoCommitFlag ) { //mybatis는 오토커밋이 기본적으로 없어서, 오토커밋 할건지를 매개변수로 받아서 결정.
		SqlSession ss = null;
		
		try {
			ss=getSessionFactory().openSession(autoCommitFlag);
		} catch (IOException e) {
			e.printStackTrace();
		}//end eatch
		
		return ss;
	}//getMyBatisHandler
	
}//class
