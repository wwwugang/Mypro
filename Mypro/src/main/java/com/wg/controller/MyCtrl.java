package com.wg.controller;

import java.io.IOException;
import com.wg.dao.DAO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyCtrl {

		@RequestMapping(value="Login",method=RequestMethod.POST)
		public String  addStudent(HttpServletRequest request,ModelMap model) throws IOException {
			
			String username=request.getParameter("username");   //调用getParameter方法找到表单内name为username的数据
			String userpasswd=null;
			
			String passwd=request.getParameter("password");
			
			//设置result.jsp里面两个变量的值
			model.addAttribute("username",username);
			model.addAttribute("password",passwd);
			//
			
			
			DAO checker=new DAO();
			userpasswd=checker.selectByUsername(username);
			
			
			if(userpasswd.equals("0")){
				model.addAttribute("checked", "No sqlSessionFactory!");
				return "result";
			}
			if(userpasswd.equals(passwd)){
				model.addAttribute("checked", "Success");
				return "result";
			}
			else{
				model.addAttribute("checked", "Failure");
				return "result";
			}
		}

	}

