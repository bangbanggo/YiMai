package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.model.EasybuyUser;
import edu.black.service.UserService;
import edu.black.service.impl.UserServiceImpl;
import edu.black.util.Logger;
import edu.black.util.LoggerManager;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class ManageAction extends ActionSupport {
    private Logger logger = LoggerManager.getLogger(ManageAction.class);
    private UserService userService = new UserServiceImpl();
    private EasybuyUser user;

    public ManageAction(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        String username = (String) session.getAttribute("username");
        logger.trace(username +" init ...");
    }

    public String addUser(){
        if (userService.register(user)){
            logger.trace("add user "+user.getEuUserId());
            return SUCCESS;
        }else {
            return ERROR;
        }

    }

    public String updateUser(){
        if (userService.updateUserInfo(user)){
            logger.trace("update user "+user.getEuUserId());
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String deleteUser(){
        if (userService.deleteUser(user)){
            logger.trace("delete user "+user.getEuUserId());
            return SUCCESS;
        }else {
            return ERROR;
        }
    }


    public EasybuyUser getUser() {
        return user;
    }

    public void setUser(EasybuyUser user) {
        this.user = user;
    }
}
