package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.model.EasybuyProduct;
import edu.black.service.ShoppingService;
import edu.black.util.Logger;
import edu.black.util.LoggerManager;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class ShoppingAction extends ActionSupport {
    private Logger logger = LoggerManager.getLogger(ShoppingAction.class);
    private ShoppingService shoppingService;
    private EasybuyProduct product;
    private int quantity;

    //User info
    private String userid;
    private String username;
    private int usertype;
    private boolean isLogin = false;

    public ShoppingAction() {
        logger.trace("get into index page ");
        try {
            HttpSession session  = ServletActionContext.getRequest().getSession();
            username = (String) session.getAttribute("username");
            userid = (String) session.getAttribute("userid");
            usertype = (Integer) session.getAttribute("usertype");
            logger.trace("userid is "+userid);
            isLogin = true;
        } catch (Exception e) {
            logger.trace("no such username or not login");
        }
    }

    public void addProduct(){
        shoppingService.addProduct(product.getEpId(),userid);
    }

    public void deleteProduct(){
        shoppingService.deleteProduct(product.getEpId(),userid);
    }

    public void reduceProduct(){
        shoppingService.reduceProduct(product.getEpId(),userid);
    }

    public void alterProduct(){
        shoppingService.alterProduct(product.getEpId(),quantity,userid);
    }

    private void DoCookie(){
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        Cookie pro=null;
        if (cookies!=null){
            for (Cookie c:cookies){
                if (c.getName().equals("product")){
                    pro = c;
                }
            }
        }
        if (pro==null){
            pro = new Cookie("product","");
        }
        pro.setValue("");
    }

    public EasybuyProduct getProduct() {
        return product;
    }

    public void setProduct(EasybuyProduct product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
}
