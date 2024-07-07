package com.yoona.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yoona.common.Util;
import com.yoona.dto.BoardAttachDto;
import com.yoona.dto.BoardDto;
import com.yoona.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Setter(onMethod_ = { @Autowired })
	BoardService boardService;
	
	
	@GetMapping("/write")
	public String writeForm() {
		
		return "/board/write";
	}
	
	@PostMapping("/write")
	public String write(BoardDto board, MultipartFile attach, HttpServletRequest req) {
		
		BoardAttachDto attachment = new BoardAttachDto();
		List<BoardAttachDto> attahcments = new ArrayList<>();
		
		try {
			String dir = req.getServletContext().getRealPath("/board-attachments");
			String userFileName = attach.getOriginalFilename();
			String savedFileName = Util.makeUniqueFileName(userFileName);
			attach.transferTo(new File(dir, savedFileName));
			
			attachment.setUserFileName(userFileName);
			attachment.setSavedFileName(savedFileName);
			attahcments.add(attachment);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		board.setAttachments(attahcments);
		boardService.setBoard(board);
		
		return "redirect:/home";
	}
}







