package org.yjr.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {

    public PropertiesEntity getProInstance(String proName) throws IOException {
        PropertiesEntity propertiesEntity = new PropertiesEntity();
        Properties properties=new Properties();
        String url = Thread.currentThread().getContextClassLoader ().getResource(proName).toString().substring(6);
        //System.out.println(url);
        FileInputStream fileInputStream = new FileInputStream(url);
        properties.load(fileInputStream);
        fileInputStream.close();
        propertiesEntity.setProperties(properties);
        propertiesEntity.setUrl(url);
        return propertiesEntity;
    }

    public void saveProperties(PropertiesEntity propertiesEntity, Map<String,String> map) throws IOException {
        Properties properties = propertiesEntity.getProperties();
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            String value = map.get(key);
            properties.setProperty(key,value);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(propertiesEntity.getUrl());
        properties.store(fileOutputStream,"保存数据");
        fileOutputStream.close();
    }
}
