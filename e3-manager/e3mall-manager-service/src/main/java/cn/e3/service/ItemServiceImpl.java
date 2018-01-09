package cn.e3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.EasyUIPageBean;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
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
	/**
	 * 分页查询商品列表
	 */
	@Override
	public EasyUIPageBean itemList(Integer page, Integer rows) {
	
		TbItemExample example = new TbItemExample();
		//设置分页信息
		PageHelper.startPage(page, rows);
		//分页查询商品信息
		List<TbItem> list = itemMapper.selectByExample(example);
		
		//创建pageInfo对象获取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//创建一个返回值对象pageBean，封装返回结果
		EasyUIPageBean pageBean = new EasyUIPageBean();
		//设置总记录数
		pageBean.setTotle(pageInfo.getTotal());
		//设置查询分页记录
		pageBean.setRows(list);
		return pageBean;
	}

}
