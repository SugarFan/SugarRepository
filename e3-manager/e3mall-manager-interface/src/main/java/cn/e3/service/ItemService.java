package cn.e3.service;

import cn.e3.pojo.EasyUIPageBean;
import cn.e3.pojo.PicResult;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.E3mallResult;

public interface ItemService {
	public TbItem findItemById(Long itemId);
	
	//查询商品列表
	public EasyUIPageBean itemList(Integer page,Integer rows);
	
	
	//保存商品
	public E3mallResult saveItem(TbItem item, TbItemDesc desc);
	
}
