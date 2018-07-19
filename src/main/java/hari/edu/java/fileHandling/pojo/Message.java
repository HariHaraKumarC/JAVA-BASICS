package hari.edu.java.fileHandling.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by harih on 7/18/2018.
 */
@XmlRootElement(name="message")
public class Message {

    String uuid;
    String companyName;
    String content;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return "UUID:"+ uuid +"; CompanyName:"+companyName+"; content:"+content;
    }
}
