package com.product.demo.request;

import com.product.demo.utils.Base;

import javax.ws.rs.QueryParam;

/**
 * Description:
 * Created with IntelliJ IDEA.
 * User: zhangyingjie
 * Date: 2018/12/10
 * Time: 下午9:09
 */
public class ProductRequest extends Base {

    @QueryParam("id")
    private Long id;

    @QueryParam("type")
    private Integer type;

    @QueryParam("limit")
    private Integer limit;

    @QueryParam("page")
    private Integer page;

    @QueryParam("offset")
    private Integer offset;

    @QueryParam("status")
    private Integer status;

    public Integer getOffset(){
        if (null == offset && page != null && limit != null) {
            offset = (page - 1) * limit;
        }
        return offset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
