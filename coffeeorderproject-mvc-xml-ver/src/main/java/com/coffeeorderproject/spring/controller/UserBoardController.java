package com.coffeeorderproject.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import com.coffeeorderproject.spring.dto.BoardAttachDto;
import com.coffeeorderproject.spring.dto.BoardCommentDto;
import com.coffeeorderproject.spring.dto.BoardDto;
import com.coffeeorderproject.spring.dto.ProductDto;
import com.coffeeorderproject.spring.service.UserBoardService;
import com.coffeeorderproject.spring.ui.DownloadView;
import com.coffeeorderproject.spring.ui.ThePager;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

@Controller
public class UserBoardController {
	
	@Setter(onMethod_ = @Autowired)
	UserBoardService boardService;
	
	@GetMapping("/board/review")
	public String reviewForm(@RequestParam(name = "pageNo", defaultValue = "1") int pageNo, HttpServletRequest req, Model model) {
//		
//		int pageNum = 1;
//		try {
//			pageNum = Integer.parseInt(req.getParameter("pageNo"));
//		} catch (Exception ex) {	}
//		
		int pageSize = 5;
		int pagerSize = 3;
		int dataCount = boardService.getBoardCount();
		/* String linkUrl = "review"; */
		
		String uri = req.getRequestURI();
		String linkUrl = uri.substring(uri.lastIndexOf("/")+1);
		String queryString = req.getQueryString();
		
		
		int start = pageSize * (pageNo - 1) + 1;
		
		ThePager pager = new ThePager(dataCount, pageNo, pageSize, pagerSize, linkUrl, queryString);
		
		List<BoardDto> boardList = boardService.findReviewBoardByRange(start, pageSize);
		List<ProductDto> prodList = boardService.findProdNameList();
		
		model.addAttribute("prodList", prodList);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pager", pager);
		model.addAttribute("pageNo", pageNo);
		
		
		return "/board/review";
	}
	
	@GetMapping("/board/detail")
	public String reviewDetail(Integer boardNo, Model model) {
		System.out.println(boardNo);
		if(boardNo != null) {
			BoardDto board = boardService.findBoardByBoardNo(boardNo);
			model.addAttribute("board", board);
		}
		return "/board/review-detail";
	}
	
	@GetMapping("/board/download")
	public View boardDownload(int attachNo, Model model) {
		BoardAttachDto boardAttach = boardService.findBoardAttachByAttachNo(attachNo);
		model.addAttribute("attach", boardAttach);
		
		return new DownloadView();
	}
	
	@PostMapping(path = {"/board/write-comment"}, produces ="text/plain;charset=utf-8")
	public String writeComment(BoardCommentDto comment, Model model) {
		
		System.out.println(comment.getBoardNo());
		boardService.writeComment(comment);
		return "redirect:/board/detail?boardNo="+ comment.getBoardNo();
	}
	
	
	
	// /////////////////////////////////////////// 아래 메서드 체크 수정 ///////////////////////////////
	@GetMapping(path = {"/board/comment-list"})
	public String listComment(int boardNo, Model model) {
		
		List<BoardCommentDto> comments = boardService.findBoardCommentsByBoardNo(boardNo);
		model.addAttribute("comments", comments);
		
		return "/board/comment-list";
			
	}

}
