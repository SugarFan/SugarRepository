package cn.e3.controller;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.pojo.TbItem;
import cn.e3.service.ItemService;

@Controller
public class itemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("findItemById/{itemId}")
	@ResponseBody
	public  TbItem findItemByID(@PathVariable("itemId")Long itemId){
		TbItem item = itemService.findItemById(itemId);
		System.err.println(item);
		return item;
	} 
}
