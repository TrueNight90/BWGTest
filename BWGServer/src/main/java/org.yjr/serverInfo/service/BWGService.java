package org.yjr.serverInfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.yjr.serverInfo.entity.BwgServerInfo;
import org.yjr.utils.MailSenderUtil;
import org.yjr.utils.entity.MailDO;

import java.util.*;

@Service
public class BWGService {

    private Logger logger = LoggerFactory.getLogger(BWGService.class);

    @Autowired
    private BWGRepository bwgRepository;

    @Autowired
    private MailSenderUtil mailSenderUtil;

    public List<BwgServerInfo> findAll(){
        return bwgRepository.findAll();
    }

    public BwgServerInfo getDefaultInfo(){
        BwgServerInfo bwgServerInfo = bwgRepository.findAll().get(0);
        bwgServerInfo = baseEncode(bwgServerInfo);
        return bwgServerInfo;
    }

    public BwgServerInfo findById(Long id){
        return bwgRepository.getOne(id);
    }

    public void saveInfo(BwgServerInfo bwgServerInfo){
        bwgRepository.save(bwgServerInfo);
    }

    public void saveInfoDetail(BwgServerInfo bwgServerInfo){
        BwgServerInfo bwgServerInfo1 = null;
        bwgServerInfo1 = bwgRepository.saveAndFlush(bwgServerInfo);
        if(null != bwgServerInfo1){
            MailDO mailDO = new MailDO();
            mailDO.setMailPath("mail/infoChange");
            mailDO.setSubject("新端口地址");
            Map map = new HashMap();
            map.put("port",bwgServerInfo1.getPort());
            mailDO.setMap(map);
            List list = new ArrayList();
            list.add("546710786@qq.com");
            list.add("451062614@qq.com");

            mailSenderUtil.sendTemplateMail(list,mailDO);
        }

    }

    public BwgServerInfo findByEntity(BwgServerInfo bwgServerInfo){
        BwgServerInfo ex = new BwgServerInfo();
        ex.setIp(bwgServerInfo.getIp());
        Example<BwgServerInfo> example = Example.of(ex);
        List<BwgServerInfo> all = bwgRepository.findAll(example);
        if(all.size()==1){
            return all.get(0);
        }
        return null;
    }

    public BwgServerInfo baseEncode(BwgServerInfo bwgServerInfo){
        String url = bwgServerInfo.getPwdType()+":"+bwgServerInfo.getPassword()+"@"+bwgServerInfo.getIp()+":"+bwgServerInfo.getPort();
        Base64.Encoder encoder = Base64.getEncoder();
        String ssUrl = "ss://" + new String(encoder.encode(url.getBytes()));
        bwgServerInfo.setSsUrl(ssUrl);
        return bwgServerInfo;
    }
}
