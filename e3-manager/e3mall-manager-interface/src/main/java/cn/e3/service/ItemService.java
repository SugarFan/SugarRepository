package cn.e3.service;

import cn.e3.pojo.EasyUIPageBean;
import cn.e3.pojo.TbItem;

public interface ItemService {
	public TbItem findItemById(Long itemId);
	
	//查询商品列表
	public EasyUIPageBean itemList(Integer page,Integer rows);
}
