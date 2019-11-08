package com.kb.mybatis.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberDTO {

	private int idx;
	private String name;
	private int age;
	private String rgdate;
	
}