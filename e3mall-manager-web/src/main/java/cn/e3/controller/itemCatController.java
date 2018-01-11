package cn.e3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.pojo.EasyUITreeNode;
import cn.e3.service.ItemCatService;

@Controller
public class itemCatController {
	@Autowired
	private ItemCatService itemCatService;
	/**
	 * 查询全部商品树形节点（根据父节点查询子节点）
	 * @param parentId
	 * @return
	 */
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> findItemCatList(
				@RequestParam(defaultValue="0",value="id")Long parentId){
		List<EasyUITreeNode> list = itemCatService.findItemCatList(parentId);
		return list;
	}
}
