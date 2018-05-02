package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.util.Logger;
import edu.black.util.LoggerManager;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class JsonAction extends ActionSupport {
    Logger logger = LoggerManager.getLogger(JsonAction.class);
    private String username;
    private String userid;
    public String getUserInfo(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        username = (String) session.getAttribute("username");
        userid = (String) session.getAttribute("userid");
        logger.trace(username);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
