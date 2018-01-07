package cn.e3.service;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
import cn.e3.pojo.TbItemExample.Criteria;
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem findItemById(Long itemId) {
		//根据id查询，设置参数
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}

}
