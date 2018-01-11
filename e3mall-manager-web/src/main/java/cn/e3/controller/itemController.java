package cn.e3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.service.ItemService;
import cn.e3.utils.E3mallResult;

@Controller
public class itemController {
	@Autowired
	private ItemService itemService;
	/**
	 * 通过id查询商品列表
	 * @param itemId
	 * @return
	 */
	@RequestMapping("findItemById/{itemId}")
	@ResponseBody
	public  TbItem findItemByID(@PathVariable("itemId")Long itemId){
		TbItem item = itemService.findItemById(itemId);
		System.err.println(item);
		return item;
	} 
	
	
	/**
	 * 需求：保存商品
	 * 
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public E3mallResult saveItem(TbItem item, TbItemDesc desc){
		E3mallResult result = itemService.saveItem(item, desc);
		return result;
	}
	
}
