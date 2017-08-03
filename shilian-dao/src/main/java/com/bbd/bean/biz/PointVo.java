package com.bbd.bean.biz;

import com.bbd.excel.ExcelRow;
import com.bbd.excel.ExcelTitle;

/**
 * 节点信息
 * 
 * @author manailin
 * @version $Id: PointVo.java, v 0.1 2016年12月8日 下午3:44:45 manailin Exp $
 */
@ExcelTitle("关联企业信息表")
public class PointVo {

    /**节点名称*/
    @ExcelRow("企业名称")
    private String name;

    /**节点所处关联方度数，为0即为目标公司*/
    @ExcelRow("节点所处关联方度数")
    private String level;

    /**该节点是否为自然人(0为企业1位自然人)*/
    @ExcelRow("该节点是否为自然人")
    private String isPerson;

    /**该节点是否为子公司(0为否1为是)  全部默认为0*/
    @ExcelRow("该节点是否为子公司(0为否1为是)")
    private String isSonCom = "0";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(String isPerson) {
        this.isPerson = isPerson;
    }

    public String getIsSonCom() {
        return isSonCom;
    }

    public void setIsSonCom(String isSonCom) {
        this.isSonCom = isSonCom;
    }

}
