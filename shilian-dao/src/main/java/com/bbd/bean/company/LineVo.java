package com.bbd.bean.company;

import com.excel.annotation.ExcelRow;
import com.excel.annotation.ExcelTitle;

/**
 * 连线信息
 * 
 * @author manailin
 * @version $Id: LineVo.java, v 0.1 2016年12月8日 下午3:46:28 manailin Exp $
 */
@ExcelTitle("关联企业信息表")
public class LineVo {

    /**源节点名称*/
    @ExcelRow("投资方")
    private String orig;

    /**目标节点名称*/
    @ExcelRow("被投资方")
    private String target;

    /**关联方关系*/
    @ExcelRow("关联关系")
    private String relationShip;

    /**源节点所处关联方度数*/
    @ExcelRow("关联方情况(投资方)")
    private String origLevel;

    /**目标节点所处关联方度数*/
    @ExcelRow("关联方情况(被投资方)")
    private String tarLevel;

    /**关联方类型   法定代表人,总经理,副董事长 */
    @ExcelRow("关系类型 (1:股东,0:董监高)")
    private String type;

    /**连线类型(0为虚线1为实线)  全部要默认为1*/
    @ExcelRow("是否自然人(1:是,0:否)")
    private String isFullLine;

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIsFullLine() {
        return isFullLine;
    }

    public void setIsFullLine(String isFullLine) {
        this.isFullLine = isFullLine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip;
    }

    public String getOrigLevel() {
        return origLevel;
    }

    public void setOrigLevel(String origLevel) {
        this.origLevel = origLevel;
    }

    public String getTarLevel() {
        return tarLevel;
    }

    public void setTarLevel(String tarLevel) {
        this.tarLevel = tarLevel;
    }

}
