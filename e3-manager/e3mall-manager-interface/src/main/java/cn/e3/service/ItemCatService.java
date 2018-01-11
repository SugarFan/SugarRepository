package cn.e3.service;

import java.util.List;

import cn.e3.pojo.EasyUITreeNode;

public interface ItemCatService {
	/**
	 * 参数：parentId
	 * 返回值：tree_Node json 格式数据：List<EasyUITreeNode>
	 * 
	 */
	public List<EasyUITreeNode> findItemCatList(Long parentId);
}
