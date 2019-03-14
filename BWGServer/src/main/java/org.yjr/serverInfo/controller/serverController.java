package org.yjr.serverInfo.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.yjr.httpclient.BWGServerWebServiceImpl;
import org.yjr.httpclient.BWGServerWebServiceImplService;
import org.yjr.serverInfo.entity.BwgServerInfo;
import org.yjr.serverInfo.entity.ResponseServerEntity;
import org.yjr.serverInfo.service.BWGService;

import java.util.List;

@Controller
public class serverController {
    private Logger logger = LoggerFactory.getLogger(serverController.class);

    @Autowired
    private BWGService bwgService;

    @RequestMapping("/Infos")
    @ResponseBody
    public List<BwgServerInfo> findInfos(){
        return bwgService.findAll();
    }

    @RequestMapping("/Info")
    @ResponseBody
    public BwgServerInfo getDefaultInfo(){
        return bwgService.getDefaultInfo();
    }

    @RequestMapping("/Info/{id}")
    @ResponseBody
    public BwgServerInfo findInfoById(@PathVariable long id){
        return bwgService.findById(id);
    }

    @RequestMapping("/Info/{id}/{port}")
    @ResponseBody
    public void setServerInfo(@PathVariable("id") Long id,@PathVariable("port") String port){
        BwgServerInfo bwgServerInfo = bwgService.findById(id);
        bwgServerInfo.setPort(port);
        bwgService.saveInfo(bwgServerInfo);
    }
    @RequestMapping("/Index")
    public ModelAndView index(){
        return new ModelAndView("serverInfo");
    }

    @PostMapping("/Info")
    @ResponseBody
    public void saveInfoDetail(BwgServerInfo bwgServerInfo){
        bwgService.saveInfoDetail(bwgServerInfo);
    }

    @RequestMapping("/ServerInfo")
    @ResponseBody
    public ResponseServerEntity saveInfoByWebService(){
        ResponseServerEntity result = new ResponseServerEntity();
        try{
            BWGServerWebServiceImplService factory = new BWGServerWebServiceImplService();
            BWGServerWebServiceImpl webService = factory.getBWGServerWebServiceImplPort();
            String info = webService.showServer("info");
            BwgServerInfo bwgServerInfo = JSON.parseObject(info, BwgServerInfo.class);
            BwgServerInfo byEntity = bwgService.findByEntity(bwgServerInfo);
            logger.info(JSON.toJSONString(byEntity));
            if(null!=byEntity){
                bwgServerInfo.setId(byEntity.getId());
            }
            bwgService.saveInfo(bwgServerInfo);
            result.setObj(bwgServerInfo);
        }catch (Exception e){
            result.setFlag(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/ServerInfo/{port}")
    @ResponseBody
    public ResponseServerEntity modifyInfoByWebService(@PathVariable String port){
        ResponseServerEntity result = new ResponseServerEntity();
        BWGServerWebServiceImplService factory = new BWGServerWebServiceImplService();
        BWGServerWebServiceImpl webService = factory.getBWGServerWebServiceImplPort();
        boolean info = webService.changeServer(port);
        result.setFlag(info);
        result.setMsg("端口修改成功");
        ResponseServerEntity responseServerEntity = saveInfoByWebService();
        result.setObj(responseServerEntity.getObj());
        result.setFlag(responseServerEntity.isFlag());
        return result;
    }

    @RequestMapping("/softs")
    public String toSofts(){
        return "softs";
    }
}
