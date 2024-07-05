package com.demoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoweb.dto.BoardCommentDto;
import com.demoweb.service.BoardService;

import lombok.Setter;

@RestController // 모든 @~Mapping에 @ResponseBody를 자동으로 설정하는 녀석 -- Ajax 응답 전용? 컨트롤러로 생각하래.
@RequestMapping("/board")
public class CommentRestController {

	@Setter(onMethod_ = {@Autowired})
	BoardService boardService;
	
	@PostMapping(path = {"/write-comment"}, produces ="text/plain;charset=utf-8")
	//@ResponseBody //@RestController 클래스에서는 생략
	public String writeComment(BoardCommentDto comment) {
		
		String result = "success";
		try {
			boardService.writeComment(comment);		
		} catch (Exception e) {
			result = "fail";
		}
		
		return result;
	}
}
