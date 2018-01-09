package cn.e3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.pojo.EasyUIPageBean;
import cn.e3.service.ItemService;


@Controller
public class pageController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("{page}")
	public String showPage(String page){
		return page;
	}
	@RequestMapping("/item/list")
	public @ResponseBody EasyUIPageBean findItembypage(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="30")Integer rows){
		
		EasyUIPageBean pageBean = itemService.itemList(page, rows);
		return pageBean;
	}
	
}
