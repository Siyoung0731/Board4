package com.green.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.green.board.dto.BoardDto;
import com.green.board.dto.BoardDto2;
import com.green.board.mapper.BoardMapper;
import com.green.menus.dto.MenuDTO;
import com.green.menus.mapper.MenuMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("/Board")
public class BoardController {
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private BoardMapper boardMapper;
	// menuList 전역변수
	
	// /Board/List?menu_id=MENU01
	@RequestMapping("/List")
	public ModelAndView list(MenuDTO mto) {
		// 메뉴 전체 목록 조회 - menus.jsp
		List<MenuDTO> menuList = menuMapper.getMenuList();
		log.info("menuList:" + menuList);
		
		// 게시물 목록 조회 - list.jsp(menu_id=MENU01)
		//List<BoardDto> boardList = boardMapper.getBoardList2("MENU01");
		List<BoardDto2> boardList = boardMapper.getBoardList(mto);
		log.info("boardList:" + boardList);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		mv.addObject("menuList", menuList);
		mv.addObject("boardList", boardList);
		return mv;
	}
	//http://localhost:8080/Board/View?idx=1
	@RequestMapping("/View")
	public ModelAndView view(BoardDto bto) {
		
		// 메뉴 목록 조회
		List<MenuDTO> menuList = menuMapper.getMenuList();
		
		//idx 글의 조회수를 1 증가
		boardMapper.incHit(bto);
		
		//idx 로 조회한 게시글
		BoardDto board = boardMapper.getBoard(bto);
		//[BoardDto [idx=2, menu_id=MENU02, title=JSP Hello, content=null, writer=JSP, regdate=2026-05-06, hit=0]
		log.debug("board:" + board);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/view");
		mv.addObject("board", board);
		mv.addObject("menuList", menuList);
		return mv;
	}
}




















