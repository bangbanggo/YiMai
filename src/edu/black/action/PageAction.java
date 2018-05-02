package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.model.*;
import edu.black.service.*;
import edu.black.service.impl.CategoryServiceImpl;
import edu.black.service.impl.CommentServiceImpl;
import edu.black.service.impl.OrderServiceImpl;
import edu.black.service.impl.ProductServiceImpl;
import edu.black.util.Logger;
import edu.black.util.LoggerManager;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class PageAction extends ActionSupport {
    private Logger logger = LoggerManager.getLogger(PageAction.class);

    //User info
    private String userid;
    private String username;
    private int usertype;

    //serive
    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private ShoppingService shoppingService = null;
    private OrderService orderService = new OrderServiceImpl();
    private CommentService commentService = new CommentServiceImpl();

    //class info
    private EasybuyProductCategoryExpand categoryExpand;
    private List<EasybuyProduct> products;
    private List<EasybuyProduct> hotProducts;
    private List<EasybuyProduct> historyProducts;
    private List<EasybuyOrderDetail> items;
    private List<EasybuyComment> comments;
    private EasybuyProduct product;
    private EasybuyComment comment;
    private Integer currentPosition;
    private boolean isLogin = false;

    //pageCounter
    private PageCounter page;

    public PageAction(){
        categoryExpand = categoryService.getCategory();
        historyProducts = getHistory();
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

    public String index(){
        products = productService.getProducts(null);
        products = products.subList(0,products.size()>6?5:products.size());
        hotProducts = productService.getProducts(null);
        return SUCCESS;
    }

    public String allProduct(){
        if (currentPosition!=null){
            products = productService.getProducts(currentPosition);
        }else if (product!=null){
            products = productService.getProducts(product);
            currentPosition = product.getEpcId();
        }else{
            return ERROR;
        }
        countPage(products,"allProduct");
        return SUCCESS;
    }

    public String productView(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        List<Integer> viewHistory = (List<Integer>)session.getAttribute("history");
        if (viewHistory==null){
            viewHistory = new ArrayList<>();
        }
        viewHistory.add(product.getEpId());
        session.setAttribute("history",viewHistory);
        product = productService.getProduct(product.getEpId());
        historyProducts = getHistory();
        currentPosition = product.getEpcId();
        return SUCCESS;
    }

    public String shopping(){
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        Cookie pro = null;
        if (cookies!=null){
            for (Cookie c:cookies){
                if (c.getName().equals("product")){
                    pro = c;
                }
            }
        }
        if (pro==null){
            return SUCCESS;
        }
        String cookieString = null;
        try {
            cookieString = URLDecoder.decode(pro.getValue(),"utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("cookie因字符编码问题无法解析");
        }
        String[] idsString = cookieString.split(",");
        List<Integer> ids=  new ArrayList<>();
        for (String s:idsString){
            ids.add(Integer.parseInt(s));
        }
        products = productService.getHistory(ids);
        return SUCCESS;
    }


    public String comment(){
        comments = commentService.getComments(null);
        countPage(comments,"comment");
        return SUCCESS;
    }

    public String submit(){
        if (!isLogin){
            return ERROR;
        }
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        Cookie pro = null;
        if (cookies!=null){
            for (Cookie c:cookies){
                if (c.getName().equals("order")){
                    pro = c;
                }
            }
        }
        if (pro==null){
            return ERROR;
        }
        String cookieString = null;
        try {
            cookieString = URLDecoder.decode(pro.getValue(),"utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("cookie因字符编码问题无法解析");
        }
        String[] idsString = cookieString.split(",");
        List<EasybuyOrderDetail> orders = new ArrayList<>();
        for (String s:idsString){
            String[] det = s.split("/");
            EasybuyOrderDetail detail = new EasybuyOrderDetail();
            detail.setEpId(Integer.parseInt(det[0]));
            detail.setEodQuantity(Integer.parseInt(det[1]));
            orders.add(detail);
        }
        if (orderService.generateOrder(orders, userid)){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    private List<EasybuyProduct> getHistory(){
        List<Integer> ids =(List<Integer>) ServletActionContext.getRequest().getSession().getAttribute("history");
        List<EasybuyProduct> result = null;
        if (ids!=null){
            result = productService.getHistory(ids);
        }else {
            result = new ArrayList<>();
        }
        return result;
    }

    private void countPage(List products,String action){
        int temp  = 1;
        if (page!=null){
            temp = page.getPageNow();
        }
        page = new PageCounter(products,temp,6);
        page.setUrl(action);
        this.products = products.subList(
                (page.getPageNow()-1)*page.getEveryPageItemCount(),
                products.size()>page.getEveryPageItemCount()*page.getPageNow()?page.getEveryPageItemCount()*page.getPageNow():products.size());
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

    public EasybuyProductCategoryExpand getCategoryExpand() {
        return categoryExpand;
    }

    public void setCategoryExpand(EasybuyProductCategoryExpand categoryExpand) {
        this.categoryExpand = categoryExpand;
    }

    public List<EasybuyProduct> getProducts() {
        return products;
    }

    public void setProducts(List<EasybuyProduct> products) {
        this.products = products;
    }

    public EasybuyProduct getProduct() {
        return product;
    }

    public void setProduct(EasybuyProduct product) {
        this.product = product;
    }

    public List<EasybuyProduct> getHotProducts() {
        return hotProducts;
    }

    public void setHotProducts(List<EasybuyProduct> hotProducts) {
        this.hotProducts = hotProducts;
    }

    public List<EasybuyProduct> getHistoryProducts() {
        return historyProducts;
    }

    public void setHistoryProducts(List<EasybuyProduct> historyProducts) {
        this.historyProducts = historyProducts;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public PageCounter getPage() {
        return page;
    }

    public void setPage(PageCounter page) {
        this.page = page;
    }

    public List<EasybuyOrderDetail> getItems() {
        return items;
    }

    public void setItems(List<EasybuyOrderDetail> items) {
        this.items = items;
    }

    public List<EasybuyComment> getComments() {
        return comments;
    }

    public void setComments(List<EasybuyComment> comments) {
        this.comments = comments;
    }

    public EasybuyComment getComment() {
        return comment;
    }

    public void setComment(EasybuyComment comment) {
        this.comment = comment;
    }
}
