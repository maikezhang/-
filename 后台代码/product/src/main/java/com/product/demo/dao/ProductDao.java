package com.product.demo.dao;

import java.util.List;

import com.product.demo.bean.ProductType;
import com.product.demo.request.ProductRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

import com.product.demo.bean.Product;

@Mapper
public interface ProductDao {

	//@Select("select * from tb_product")
    @Select("<script>"+
    "select * from tb_product where 1=1 <if test='id!=null'> and id =#{id} </if>"
    + "</script> ")
	Product  getProduct(@Param("id") String id);
    
	@Select("<script>" +
			"select * from tb_product" +
			" where status=0 " +
			"<if test='request.type!=null'> and type=#{request.type} </if>" +
			"ORDER BY weight desc" +
			"<if test='request.limit!=null'> limit #{request.limit} </if>" +
			"<if test='request.offset!=null'> offset #{request.offset} </if>" +
			"</script>")
	List<Product>  getProductList(@Param("request") ProductRequest request);
	
	@Insert("insert into tb_product tp                              "
		  + "(tp.id,tp.name,tp.`desc`,tp.price,tp.filePath,tp.status)         "
		  + "values                                                 " 
		  + "(#{id},#{name},#{desc},#{price},#{filePath},#{status})           ")
	void addProduct(Product pro);

	@Select("<script> " +
			"select * from tb_type where state=1 " +
			"</script>")
	List<ProductType> getTypes();

}
