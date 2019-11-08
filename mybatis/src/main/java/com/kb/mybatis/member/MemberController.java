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
		
		model.addAttribute("list", ss.selectList("member.selectlist"));
		
		return "member/index";
	}
	//회원수정
	@RequestMapping(value = "/update.do")
	public String update(Model model, @RequestParam int idx, MemberDTO md) {
		model.addAttribute("row",ss.selectOne("member.selectrow",idx)) ;
		return "member/update";
	}
	//회원수정 데이터베이스 저장
	@RequestMapping(value = "/updateProc.do")
	public String updateProc(Model model, int idx, String name, String age, String rgdate) {
		try {
			Integer.parseInt(age);
		} catch (Exception e) {
			return "numberException"; 
		}
		
		MemberDTO md = new MemberDTO();
		md.setAge(Integer.parseInt(age));
		md.setName(name);
		md.setIdx(idx);
		md.setRgdate(rgdate);
		
		System.out.println("md = " + md);
		
		ss.insert("member.updaterow",md);

		return "redirect:index.do";
	}
	
	//회원등록
	@RequestMapping(value = "/insert.do")
	public String insert(Model model) {
		return "member/insert";
	}
	
	//회원등록 데이터베이스 저장
	@RequestMapping(value = "/insertProc.do")
	public String insertProc(Model model, String name, String age) {
		try {
			Integer.parseInt(age);
		} catch (Exception e) {
			return "numberException"; 
		}
		
		MemberDTO md = new MemberDTO();
		md.setAge(Integer.parseInt(age));
		md.setName(name);
		
		System.out.println("md = " + md);
		
		ss.insert("member.insertrow",md);
		
		return "redirect:index.do";
	}
	@RequestMapping(value = "/delete.do")
	public String delete(String[] idx) {

//		for ( String temp : idx) {
//			System.out.println("temp = " + temp);
//		}
				
		String idxs = "";
		
		for ( int i = 0 ; i < idx.length ; i++) {
			if ( i == idx.length-1 ) {
				idxs = idxs + idx[i];
			} else {
				idxs = idxs + idx[i]+",";
			}
		}
//		System.out.println(idxs);
		
		ss.delete("member.deleterows",idxs);
		
		return "redirect:index.do";
	}
}