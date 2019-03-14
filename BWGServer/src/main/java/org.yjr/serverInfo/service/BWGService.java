package org.yjr.serverInfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.yjr.serverInfo.entity.BwgServerInfo;

import java.util.Base64;
import java.util.List;

@Service
public class BWGService {

    private Logger logger = LoggerFactory.getLogger(BWGService.class);

    @Autowired
    private BWGRepository bwgRepository;

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
        bwgRepository.saveAndFlush(bwgServerInfo);
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
