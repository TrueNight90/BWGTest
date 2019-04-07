package org.yjr.utils.entity;

import java.util.Map;

public class MailDO {
    private String subject;
    private String text;
    private String mailPath;
    private Map map;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMailPath() {
        return mailPath;
    }

    public void setMailPath(String mailPath) {
        this.mailPath = mailPath;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
