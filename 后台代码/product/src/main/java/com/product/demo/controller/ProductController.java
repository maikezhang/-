package com.product.demo.controller;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.product.demo.request.ProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.product.demo.bean.Product;
import com.product.demo.bean.ResBean;
import com.product.demo.service.ProductService;
import com.product.demo.utils.HttpUtils;
import com.product.demo.utils.Response;

@RestController
public class ProductController {
	
	private final static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
    @Autowired  
    private Environment env;  
	
	@Autowired
	ProductService service;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	
	/**
	 * 获取微信授权
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/wx/auth")
	public Response wxLogin(@RequestParam Map map) {
		ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
		try {
			map.put("appid", env.getProperty("appid"));
			map.put("secret", env.getProperty("appscret"));
			map.put("grant_type", "authorization_code");
			logger.info(map.toString());
			String wx_auth_login = valueOperations.get("wx_auth_login");
			if(wx_auth_login!=null) {
				ResBean b = new ResBean(wx_auth_login,"1");
				return Response.ok(b);
			}else {
				String s = HttpUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session",map);
				JSONObject json = JSONObject.parseObject(s);
				if(json.get("openid")!=null) {
					String wx_auth = UUID.randomUUID().toString();
					valueOperations.set("wx_auth_login",wx_auth, Duration.ofDays(7));
					ResBean b = new ResBean(wx_auth,"1");
					return Response.ok(b);
				}
			}
		} catch (Exception e) {
			logger.error("获取微信授权失败!");
			e.printStackTrace();
		}
		return Response.err();
	}
	
	/**
	 * 新增商品
	 * @param
	 * @return
	 */
	@RequestMapping(value="/product/add")
	public Response addPro(@Valid Product pro, BindingResult bindingResult) {
		try {
		    if(bindingResult.hasErrors()){
		    	return Response.err(bindingResult.getFieldError().getDefaultMessage());
		    }
		    pro.setId(UUID.randomUUID().toString());
		    service.addProduct(pro);
			System.out.println(pro.toString());
		} catch (Exception e) {
			logger.error("新增商品失败！");
			e.printStackTrace();
		}
		return Response.ok(pro);
	}
	
	/**
	 *  查询某个商品
	 * @param
	 * @return
	 */
	@RequestMapping("/product/selectProduct")
	public Response selectProduct(@RequestParam String id) {
		try {
			Product pro = service.product(id);
			return Response.ok(pro);
		} catch (Exception e) {
			logger.error("查询商品失败！");
			e.printStackTrace();
		}
		return Response.err();
	}
	
	/**
	 *  查询商品列表
	 * @param
	 * @return
	 */
	@RequestMapping("/product/productList")
	public Response productList(ProductRequest request) {
		try {
			List<Product> list = service.productList(request);
			return Response.ok(list);
		} catch (Exception e) {
			logger.error("查询商品失败！");
			e.printStackTrace();
		}
		return Response.err();
	}

	@RequestMapping("/product/typeList")
	public Response typeList(){
		return Response.ok(service.getTypes());
	}
	 
}
