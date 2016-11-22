package com.wg.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DAO {
	private SqlSessionFactory sqlSessionFactory = null;
	public DAO() throws IOException{
		}
	
	public String selectByUsername(String id){
		
		String resource = "applicationContext.xml";  //��XML�ļ�ת���ַ���
        
		InputStream inputStream = null;
        
		try {
			inputStream = Resources.getResourceAsStream(resource);  //���ַ���rousourceת��������
		} 
		catch (IOException m) {
			return "0";
		}
		
		
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);  //�������������������ӳصĺ���
        String userpasswd = null;

        SqlSession session = sqlSessionFactory.openSession();
        try {
        	 userpasswd = (String)session.selectOne("com.wg.mybatis.selectByUsername",id);
 
        } finally {
            session.close();
        }
        return userpasswd;
    } 
}
