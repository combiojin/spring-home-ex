package com.kb.mybatis.member;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired
	SqlSession ss;
	
	@RequestMapping(value = "/index.do")
	public String index(Model model) {
		
		return "member/index";
	}
	
	@RequestMapping(value = "/update.do")
	public String update(Model model, @RequestParam int idx, MemberDTO md) {

		return "member/update";
	}
	
	@RequestMapping(value = "/updateProc.do")
	public String updateProc(Model model,MemberDTO md) {

		return "redirect:index.do";
	}
	
	@RequestMapping(value = "/insert.do")
	public String insert(Model model) {
		return "member/insert";
	}
	
	@RequestMapping(value = "/insertProc.do")
	public String insertProc(Model model, String title, String content, MemberDTO md) {

		return "redirect:index.do";
	}
	@RequestMapping(value = "/delete.do")
	public String delete(String[] idx) {

		return "redirect:index.do";
	}
}









