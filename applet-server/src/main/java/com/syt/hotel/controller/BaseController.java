package com.syt.hotel.controller;

import com.syt.hotel.page.PageData;
import com.syt.hotel.page.Pager;
import com.syt.hotel.utils.Result;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @program: springboot
 * @description:
 * @author: jinlu
 * @create: 2020-11-25 14:27
 **/
public class BaseController {

    protected Logger log = Logger.getLogger(this.getClass());

    /**
     * 返回分页数据结果
     * @param list
     * @param total
     * @param pageSize
     * @param p
     * @return
     */
    protected Result pageResult(List list, long total, Integer pageSize, Integer p){
        Result rlt = new  Result(new PageData(list, createPage(total,pageSize,p)));
        rlt.setTotal(total);
        return rlt;
    }

    /**
     * 返回分页数据结果
     * @param pager
     * @return
     */
    protected Result pageResult(Pager pager){
        Result rlt = new  Result(new PageData(pager.getDatas(), createPage(pager.getTotal(),pager.getEnd()-pager.getStart(),pager.getPageNum())));
        rlt.setTotal(pager.getTotal());
        return rlt;
    }

    /**
     * 创建列表的分页
     * @param total
     * @param pageSize
     * @param p
     * @return
     */
    protected  String createPage(long total,Integer pageSize,Integer p){
        pageSize = pageSize==null?10:pageSize;
        p = p==null?1:p;
        StringBuffer page = new StringBuffer();
        //如果传递的p是0开始的，转换成第一页
        if(p<=0){
            p = 1;
        }
        //总的页面数
        long totalPages =  total%pageSize >0 ? total/pageSize +1 :total/pageSize;
        int prePage = p-1;
        int nextPage = p+1;
        if(prePage>0){
            page.append("<a class=\"prev fetch_page\" data-page-num=\""+prePage+"\" href=\"javascript:;\">上一页</a>");
        }
        page.append("<span class=\"total\">共 "+total+" 条，每页 "+pageSize+" 条</span>");
        //在当前页面前添加按钮
        if(p>3){
            page.append(" <a data-page-num=\"1\" class=\"fetch_page num\" href=\"javascript:void(0);\">1</a>");
            page.append("                ...");
            page.append(" <a data-page-num=\""+ (p-1)+"\" class=\"fetch_page num\" href=\"javascript:void(0);\">"+ (p-1)+"</a>");
        }else if(p==3){
            page.append(" <a data-page-num=\"1\" class=\"fetch_page num\" href=\"javascript:void(0);\">1</a>");
            page.append(" <a data-page-num=\""+ (p-1)+"\" class=\"fetch_page num\" href=\"javascript:void(0);\">"+ (p-1)+"</a>");
        }else if(p==2){
            page.append(" <a data-page-num=\"1\" class=\"fetch_page num\" href=\"javascript:void(0);\">1</a>");
        }
        //创建当前页面
        page.append("    <a data-page-num=\""+p+"\" href=\"javascript:;\" class=\"num active\">"+p+"</a>");
        //在当前页面后面添加按钮
        if(totalPages-p>2){
            page.append(" <a data-page-num=\""+ (p+1)+"\" class=\"fetch_page num\" href=\"javascript:void(0);\">"+ (p+1)+"</a>");
            page.append("                ...");
            page.append(" <a data-page-num=\""+ totalPages+"\" class=\"fetch_page num\" href=\"javascript:void(0);\">"+ totalPages+"</a>");
        }else if(totalPages-p==2){
            page.append(" <a data-page-num=\""+ (totalPages-1)+"\" class=\"fetch_page num\" href=\"javascript:void(0);\">"+ (totalPages-1)+"</a>");
            page.append(" <a data-page-num=\""+ totalPages+"\" class=\"fetch_page num\" href=\"javascript:void(0);\">"+ totalPages+"</a>");
        }else if(totalPages-p==1){
            page.append(" <a data-page-num=\""+ totalPages+"\" class=\"fetch_page num\" href=\"javascript:void(0);\">"+ totalPages+"</a>");
        }
        page.append("<span class=\"js-goto goto\">");
        page.append("    <span class=\"js-goto-input js-jump-page goto-input\" contenteditable=\"true\">"+p+"</span>");
        page.append("    <span>/ "+totalPages+"页</span>");
        page.append("</span>");

        if(nextPage<=totalPages){
            page.append("<a class=\"fetch_page next\" data-page-num=\""+nextPage+"\" href=\"javascript:;\">下一页</a>");
        }
        return page.toString();
    }
}