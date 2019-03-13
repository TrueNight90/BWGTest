package org.yjr.serverInfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.yjr.serverInfo.entity.BwgServerInfo;

import java.util.List;

@Service
public class BWGService {

    private Logger logger = LoggerFactory.getLogger(BWGService.class);

    @Autowired
    private BWGRepository bwgRepository;

    public List<BwgServerInfo> findAll(){
        return bwgRepository.findAll();
    }

    public BwgServerInfo getDefaultInfo(){ return bwgRepository.findAll().get(0);}

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
}
