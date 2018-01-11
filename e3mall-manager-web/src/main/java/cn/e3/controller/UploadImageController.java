package cn.e3.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mchange.v2.async.StrandedTaskReporting;

import cn.e3.pojo.PicResult;
import cn.e3.utils.FastDFSClient;
import cn.e3.utils.JsonUtils;

@Controller
public class UploadImageController {
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	/**
	 * 上传图片是把图片直接上传到fastDFS图片服务器上与Service、dao无关
	 * 请求：/pic/upload
	 * 参数:MultipartFile  uploadFile
	 * 返回值：json格式     PicResult
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadPic(MultipartFile uploadFile){
		
		try {
			//获取文件名字
			String filename = uploadFile.getOriginalFilename();
			//获取文件扩展名
			String extName = filename.substring(filename.lastIndexOf(".")+1);
			//创建图片服务器上传工具类
			FastDFSClient client = new FastDFSClient("classpath:client.conf");
			String url = client.uploadFile(uploadFile.getBytes(),extName);
			//组合url图片服务器完整路径
			url = IMAGE_SERVER_URL + url;
			
			//创建一个PicResult对象，设置返回值结果
			PicResult picResult = new PicResult();
			picResult.setUrl(url);
			picResult.setError(0);
			
			/**
			 * 因为只有谷歌支持富文本编辑器，所以要把json对象转换为json字符串
			 */
			String picJson = JsonUtils.objectToJson(picResult);
			
			return picJson;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PicResult picResult = new PicResult();
			picResult.setError(1);
			picResult.setMessage("上传失败");
			
			String picJson = JsonUtils.objectToJson(picResult);
			
			return picJson;
			
		}
	}
	
	
	
}
