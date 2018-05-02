package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.model.EasybuyUser;
import edu.black.service.UserService;
import edu.black.service.impl.UserServiceImpl;
import edu.black.util.Logger;
import edu.black.util.LoggerConsole;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class UsersAction extends ActionSupport {
    private Logger logger = new LoggerConsole();
    private EasybuyUser user ;
    private UserService userService  = new UserServiceImpl();
    private String veryCode;//登录验证码


    public String prelogin(){
        return SUCCESS;
    }

    public String login(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        String receiveCode = (String) session.getAttribute("rand");
        if (!veryCode.equals(receiveCode)){
            return ERROR;
        }
        logger.trace("login "+user);
        if (user!=null && user.getEuUserName() != null && user.getEuPassword()!= null&&(user=userService.login(user))!=null){

            session.setAttribute("username",user.getEuUserName());
            session.setAttribute("userid",user.getEuUserId());
            session.setAttribute("usertype",user.getEuStatus());
            logger.trace("login success");
            return SUCCESS;
        }else {
            logger.trace("login fail");
            return ERROR;
        }

    }

    public String register(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        String receiveCode = (String) session.getAttribute("rand");
        if (!veryCode.equals(receiveCode)){
            return ERROR;
        }
        logger.trace("register");
        if (user!=null){
            user.setEuStatus(1);//普通用户级别
        }
        if (user!=null && user.getEuUserName() != null && user.getEuPassword()!= null &&userService.register(user)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String logout(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        logger.trace((String)session.getAttribute("username")+" logout ");
        session.removeAttribute("username");
        session.removeAttribute("userid");
        session.removeAttribute("usertype");
        return SUCCESS;
    }

    public void getUserInfo(){

    }
    public EasybuyUser getUser() {
        return user;
    }

    public void setUser(EasybuyUser user) {
        this.user = user;
    }

    public String getVeryCode() {
        return veryCode;
    }

    public void setVeryCode(String veryCode) {
        this.veryCode = veryCode;
    }
}
