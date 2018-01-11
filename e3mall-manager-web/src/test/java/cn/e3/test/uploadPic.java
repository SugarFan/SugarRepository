package cn.e3.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3.utils.FastDFSClient;

public class uploadPic {
	/**
	 * 上传图片
	 * @throws Exception 
	 */
	@Test
	public void upload() throws Exception{
		//图片上传路径
		String clientPath = "D:\\旅游\\西安记忆\\1461015272001_share.jpg";
		//指定服务器路径，指定Client.conf路径
		String path="D:\\GitRepository\\SugarRepository\\e3mall-manager-web\\src\\main\\resources\\client.conf";
		//加载配置文件，连接服务器
		ClientGlobal.init(path);
		
		//创建tracker 客户端
		TrackerClient tClient = new TrackerClient();
		
		//从客户端获取tracker对象
		TrackerServer trackerServer = tClient.getConnection();

		StorageServer storageServer = null;
		
		//创建storageClient客户端
		StorageClient sClient = new StorageClient(trackerServer,storageServer);
		
		//上传
		String[] file = sClient.upload_file(path, "jpg", null);
		
		for (String str : file) {
			System.out.println(str);
		}
		
		
	}
	@Test
	public void uploadByUtils() throws Exception{
		//图片上传路径
		String path = "D:\\旅游\\西安记忆\\1461015754352_share.jpg";
		//指定服务器路径，指定Client.conf路径
		String clientPath="D:\\GitRepository\\SugarRepository\\e3mall-manager-web\\src\\main\\resources\\client.conf";
		
		FastDFSClient client = new FastDFSClient(clientPath);
		String file = client.uploadFile(path);
		System.out.println(file);
		
		
		
	}
	
	
	
	
}
