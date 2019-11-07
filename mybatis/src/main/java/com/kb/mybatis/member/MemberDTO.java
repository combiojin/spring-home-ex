package com.kb.mybatis.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberDTO {

	private int idx;
	private String title;
	private String content;
	private String rgdate;
	
}
