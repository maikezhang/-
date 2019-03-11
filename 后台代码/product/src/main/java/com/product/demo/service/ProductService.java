package com.product.demo.service;

import java.util.List;

import com.product.demo.bean.ProductType;
import com.product.demo.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.demo.dao.ProductDao;

import com.product.demo.bean.Product;

@Service
public class ProductService {
	
    @Autowired
    ProductDao dao;
	
    /**
     * 获取单个商品
     * @param id
     * @return
     */
	public Product product(String id){
		Product pro = dao.getProduct(id);
		return pro;
	}
	
	/**
	 * 获取商品列表
	 * @return
	 */
	public List<Product> productList(ProductRequest request){



		List<Product> list = dao.getProductList(request);
		return list;
	}
	
	/**
	 * 添加商品
	 * @param pro
	 */
	@Transactional
	public void addProduct(Product pro){
		dao.addProduct(pro);
	}


	public List<ProductType> getTypes(){
		return dao.getTypes();
	}
}
