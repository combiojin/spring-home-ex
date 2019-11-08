package com.kb.mybatis.freeboard;

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
//@RequestMapping(value = "/freeboard")
public class FreeBoardController {
	
	@Autowired
	SqlSession ss;
	
	@RequestMapping(value = "/freeboard/index.do")
	public String index(Model model) {
		
//		List<FreeBoardDTO> list = new ArrayList<FreeBoardDTO>();
//		list.add(new FreeBoardDTO(1, "aa", "aaa", "20191105"));
//		list.add(new FreeBoardDTO(2, "bb", "bbb", "20191104"));
//		list.add(new FreeBoardDTO(3, "cc", "ccc", "20191103"));
		
		List<FreeBoardDTO> list = ss.selectList("freeboard.selectlist");
		
//		org.mybatis.spring.SqlSessionTemplate ss= new SqlSessionTemplate(sqlSessionFactory)
//		Connection conn = null;
		
		model.addAttribute("list",list);
		
		return "freeboard/index";
	}
	
	@RequestMapping(value = "/freeboad/update.do")
	public String update(Model model, @RequestParam int idx, FreeBoardDTO fbd) {
		System.out.println("수정화면");
		//한개의 행을 조회해서 속성으로 가지고 가야 합니다.
//		FreeBoardDTO fbd = new FreeBoardDTO();
//		fbd.setTitle("asdfasdf");
		
		FreeBoardDTO returnfbd = ss.selectOne("freeboard.selectrow",fbd);
				
		model.addAttribute("row",returnfbd);
		
		return "freeboard/update";
	}
	
	@RequestMapping(value = "/freeboard/updateProc.do")
	public String updateProc(Model model,FreeBoardDTO fbd) {
		System.out.println("fbd = " +fbd);
		
		ss.update("freeboard.updaterow",fbd);
		//db update
//		ss.insert("freeboard.insertrow",fbd);
						
		return "redirect:index.do";
	}
	
	@RequestMapping(value = "/freeboard/insert.do")
	public String insert(Model model) {
		return "freeboard/insert";
	}
	
	@RequestMapping(value = "/freeboard/insertProc.do")
	public String insertProc(Model model, 
//			HttpServletRequest request,
//			@RequestParam String title, @RequestParam String content
			String title, String content, FreeBoardDTO fbd
			) {
		
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
		System.out.println("title = "+ title);
		System.out.println("content = "+ content);
		
		System.out.println("fbd = " + fbd);
		
		//db insert 저장
		ss.insert("freeboard.insertrow",fbd);
		
		List<FreeBoardDTO> list = ss.selectList("freeboard.selectlist");
		model.addAttribute("list",list);
		
		return "redirect:index.do";
	}
	@RequestMapping(value = "/freeboard/delete.do")
	public String delete(String[] idx) {
//		System.out.println("삭제해야됨");
//		System.out.println();
//		
//		System.out.println("spring 에서 자동 설정");
//		for(String temp : idx) {
//			System.out.println("temp =" + temp);
//		}
		String idxss = "";
		
		for ( int i = 0 ; i < idx.length; i++) {
			if(i == idx.length-1) {
				idxss = idxss + idx[i];
			}else {
				idxss = idxss + idx[i]+",";
			}
		}
		
//		System.out.println("idxss = " + idxss);
				
		ss.delete("freeboard.deleterows",idxss);
		
		return "redirect:index.do";
	}
}