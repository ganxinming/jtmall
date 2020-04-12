package com.jtmall.manager.controller;

import com.jtmall.commons.utils.FastDFSClient;
import com.jtmall.commons.utils.JsonUtils;
import com.jtmall.service.RedisService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 图片上传处理controller
 * <p>Title: PictureController</p>
 * <p>Description: </p>
 * @version 1.0
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
public class PictureController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Value("${image.server.url}")
	private String IMAGE_SERVER_URL;

	@Reference(version = "${demo.service.manager}")
	private RedisService redisUtils;

	//TODO:解决多图片上传线程竞争问题

	@RequestMapping(value = "/pic/upload/{cNumber}", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
	@ResponseBody
	public String uploadFile(HttpServletRequest request, HttpServletRequest response, HttpSession session, @PathVariable("cNumber") String cNumber) {
		try {
			//查询缓存中是否存在
			boolean hasKey = redisUtils.exists(cNumber);
			Map result = new HashMap<>();
			if (hasKey) {
				//获取缓存
				Object object = redisUtils.get(cNumber);
				String truecUrl = object.toString();
				logger.info("总url"+truecUrl);
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				MultipartFile uploadFile = multipartRequest.getFile("img");

				//把图片上传的图片服务器
				FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
				//取文件扩展名
				String originalFilename = uploadFile.getOriginalFilename();
				String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
				//得到一个图片的地址和文件名
				String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
				//补充为完整的url
				url = IMAGE_SERVER_URL + url;
				//打印下图片路径
				System.out.println("打印下图片路径:" + url);
				if (truecUrl == "") {
					//设置路径有10分钟有效期
					redisUtils.set(cNumber, url, 10L, TimeUnit.MINUTES);
				} else {
					//说明不只一张图片
					url = truecUrl + " " + url;
					redisUtils.set(cNumber, url, 10L, TimeUnit.MINUTES);
				}
				//封装到map中返回
				System.out.println("trueUrl:"+redisUtils.get(cNumber));
				result.put("success", "上传成功");
				return JsonUtils.objectToJson(result);

			}
			result.put("error", "上传失败，请填写商品正确编号");
			return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			e.printStackTrace();
			Map result = new HashMap<>();
			result.put("error", "上传失败");
			return JsonUtils.objectToJson(result);
		}


	}

}

