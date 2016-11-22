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
		
		String resource = "applicationContext.xml";  //将XML文件转成字符串
        
		InputStream inputStream = null;
        
		try {
			inputStream = Resources.getResourceAsStream(resource);  //将字符串rousource转成输入流
		} 
		catch (IOException m) {
			return "0";
		}
		
		
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);  //把输入流传给创建连接池的函数
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
