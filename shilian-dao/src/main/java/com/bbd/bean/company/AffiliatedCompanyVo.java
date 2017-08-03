package com.bbd.bean.company;

import com.bbd.bean.biz.PointVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * 关联公司信息
 * 
 * @author manailin
 * @version $Id: AffiliatedCompanyVo.java, v 0.1 2016年12月8日 下午3:40:39 manailin Exp $
 */
@ApiModel(value = "关联公司信息")
public class AffiliatedCompanyVo {

    /**关联节点集合列表*/
    @ApiModelProperty(value = "关联节点列表")
    private Set<PointVo> pointList = new HashSet<PointVo>();

    /**关联连线集合列表*/
    @ApiModelProperty(value = "关联线条列表")
    private Set<LineVo>  lineList  = new HashSet<LineVo>();

    public Set<PointVo> getPointList() {
        return pointList;
    }

    public void setPointList(Set<PointVo> pointList) {
        this.pointList = pointList;
    }

    public Set<LineVo> getLineList() {
        return lineList;
    }

    public void setLineList(Set<LineVo> lineList) {
        this.lineList = lineList;
    }

}
