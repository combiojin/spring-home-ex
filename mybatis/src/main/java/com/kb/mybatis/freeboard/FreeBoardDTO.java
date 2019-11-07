package com.kb.mybatis.freeboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FreeBoardDTO {

	private int idx;
	private String title;
	private String content;
	private String rgdate;
	
}
