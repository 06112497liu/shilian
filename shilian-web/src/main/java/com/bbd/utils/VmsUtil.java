/**
 * BBD Service Inc
 * AllRight Reserved @2017
 */
package com.bbd.utils;

import com.bbd.util.ConfigUtil;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcTtsNumSinglecallRequest;
import com.taobao.api.response.AlibabaAliqinFcTtsNumSinglecallResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 语音
 * 
 * @author xc
 * @version $Id: VmsUtil.java, v 0.1 2016年12月5日 下午1:34:58 xc Exp $
 */
public class VmsUtil {

    private static Logger log = LoggerFactory.getLogger(VmsUtil.class);

    /**
     * 获取客户端
     * 
     * @return
     */
    public static TaobaoClient getVmsClient() {
        TaobaoClient client = new DefaultTaobaoClient(ConfigUtil.getAlidayuUrl(), ConfigUtil.getAlidayuAppkey(), ConfigUtil.getAlidayuSecret());
        return client;
    }

    /**
     * 获取请求
     * 
     * @param mobile
     * @param param
     * @param templateCode
     * @return
     */
    public static AlibabaAliqinFcTtsNumSinglecallRequest getVmsRequest(String mobile, String param, String templateCode) {
        AlibabaAliqinFcTtsNumSinglecallRequest req = new AlibabaAliqinFcTtsNumSinglecallRequest();
        req.setTtsParamString(param);
        req.setCalledNum(mobile);
        req.setCalledShowNum(ConfigUtil.getVmsCalledShowNumber());
        req.setTtsCode(templateCode);
        return req;
    }

    /**
     * 获取请求
     * 
     * @param mobile
     * @param templateCode
     * @return
     */
    public static AlibabaAliqinFcTtsNumSinglecallRequest getVmsRequest(String mobile, String templateCode) {
        AlibabaAliqinFcTtsNumSinglecallRequest req = new AlibabaAliqinFcTtsNumSinglecallRequest();
        req.setCalledNum(mobile);
        req.setCalledShowNum(ConfigUtil.getVmsCalledShowNumber());
        req.setTtsCode(templateCode);
        return req;
    }

    /**
     * 发送请求
     * 
     * @param client
     * @param request
     * @return
     */
    public static String sendApi(TaobaoClient client, AlibabaAliqinFcTtsNumSinglecallRequest request) {
        try {
            AlibabaAliqinFcTtsNumSinglecallResponse rsp = client.execute(request);
            log.info("VmsUtil-send" + rsp.getBody());
            if (rsp.isSuccess()) {
                return "1";
            } else {
                return rsp.getMsg();
            }
        } catch (ApiException e) {
            log.error(e.getMessage(), e);
            return e.getMessage();
        }
    }

    /**
     * 获取VmsApi
     * 
     * @return
     */
    /*
    public static CCPRestSDK getVmsApi() {
     CCPRestSDK restAPI = new CCPRestSDK();
     restAPI.init(ConfigUtil.getRongBaseUrl(), ConfigUtil.getRongBasePort());// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
     restAPI.setAccount(ConfigUtil.getRongAccountSid(), ConfigUtil.getRongAccountToken());// 初始化主帐号和主帐号TOKEN
     restAPI.setAppId(ConfigUtil.getRongAppId());// 初始化应用ID
     return restAPI;
    }

    *//**
      * 发送语音
      * 
      * @param restAPI
      * @param mobile 电话
      * @return
      */
    /*
    public static String sendApi(CCPRestSDK restAPI, String mobile,String content,String respUrl,String userData) {
     HashMap<String, Object> result = restAPI.landingCall(mobile, null, content, null, null, respUrl, userData, null, null, null, null, null);
     log.info("SDKTestLandingCall result=" + result);
     if ("000000".equals(result.get("statusCode"))) {
         HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
         Set<String> keySet = data.keySet();
         for (String key : keySet) {
             Object object = data.get(key);
             log.info(key + " = " + object);
         }
         return "1";
     } else {
         //异常返回输出错误码和错误信息
         log.info("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
         return (String) result.get("statusMsg");
     }
    }*/

}
