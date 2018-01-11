package cn.e3.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.EasyUITreeNode;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemCatExample.Criteria;
@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUITreeNode> findItemCatList(Long parentId) {
		//创建集合，封装树形列表
		List<EasyUITreeNode> treeList = new ArrayList<>();
		//根据父id查询商品类别
		//创建example对象，类似于hibernate的qbc查询
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		
		//设置查询参数
		criteria.andParentIdEqualTo(parentId);
		//查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		for (TbItemCat tbItemCat : list) {
			//创建树形节点对象，封装商品类目数据
			EasyUITreeNode treeNode = new EasyUITreeNode();
			//封装树形节点id
			treeNode.setId(tbItemCat.getId());
			//封装树形节点名称
			treeNode.setText(tbItemCat.getName());
			//封装树形节点状态
			//三元表达式：（判断？true：false）
			treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			//封装treeNode
			treeList.add(treeNode);
		}
		return treeList;
	}

}
