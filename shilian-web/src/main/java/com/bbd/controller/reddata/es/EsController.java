/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.controller.reddata.es;

import com.bbd.service.reddata.es.IEsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 *
 * @author tjwang
 * @version $Id: EsController.java, v 0.1 2017/5/24 0024 11:47 tjwang Exp $
 */
@Controller
@RequestMapping("/es")
public class EsController {

    @Resource
    private IEsService esService;

    @RequestMapping(value = "/company/sync_full", method = RequestMethod.GET)
    public void syncCompanyFull() {
        esService.syncFullCompanyToEs();
    }

    @RequestMapping(value = "/company/sync_increment", method = RequestMethod.GET)
    public void syncCompanyIncrement() {
        esService.syncIncreaseCompanyToEs();
    }
}
