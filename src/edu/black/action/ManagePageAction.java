package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.model.*;
import edu.black.service.*;
import edu.black.service.impl.*;
import edu.black.util.Logger;
import edu.black.util.LoggerManager;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ManagePageAction extends ActionSupport {
    private Logger logger = LoggerManager.getLogger(ManagePageAction.class);

    private UserService userService =new UserServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private NewsService newsService = new NewsServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private CommentService commentService = new CommentServiceImpl();

    private String userid;
    private String username;
    private Integer usertype;

    private EasybuyProductCategoryExpand categoryExpand;
    private EasybuyProductCategory category;
    private EasybuyUser user;
    private EasybuyProduct product;
    private EasybuyNews news;
    private EasybuyOrder order;
    private EasybuyComment comment;

    private List<EasybuyProductCategory> categories;
    private List<EasybuyUser> users;
    private List<EasybuyProduct> products;
    private List<EasybuyNews> newses;
    private List<EasybuyOrder> orders;
    private List<EasybuyComment> comments;


    public ManagePageAction(){
        logger.trace("init manage page");

    }
    public String index(){
        logger.trace("get into index page ");
        HttpSession session  = ServletActionContext.getRequest().getSession();
        username = (String) session.getAttribute("username");
        userid = (String) session.getAttribute("userid");
        usertype = (Integer) session.getAttribute("usertype");
        logger.trace("userid is "+userid);
        return SUCCESS;
    }

    public String userManage(){
        logger.trace("get into userManager page ");
        users = userService.getAll();
        return SUCCESS;
    }

    public String preupdate(){
        HttpSession session  = ServletActionContext.getRequest().getSession();
        String username = (String)session.getAttribute("username");
        logger.trace(username + " is updating user:"+user.getEuUserId());
        user = userService.getUserByUserId(user);
        return SUCCESS;
    }


    //分类
    public String categoryManage(){
        categoryExpand = categoryService.getCategory();
        return SUCCESS;
    }

    public String categoryPreUpdate(){
        category = categoryService.getCategory(category.getEpcId());
        categories = categoryService.getCategories(null);
        return SUCCESS;
    }

    public String categoryPreAdd(){
        categories = categoryService.getCategories(null);
        return SUCCESS;
    }



    //产品
    public String productManage(){
        products = productService.getProducts(null);
        return SUCCESS;
    }

    public String productPreAdd(){
        categoryExpand = categoryService.getCategory();
        return SUCCESS;
    }

    public String productPreUpdate(){
        categoryExpand = categoryService.getCategory();
        product = productService.getProduct(product.getEpId());
        return SUCCESS;
    }



    //comment
    public String comment(){
        comments = commentService.getComments(null);
        return SUCCESS;
    }

    public String commentPreUpdate(){
        comment = commentService.getComment(comment.getEcId());
        return SUCCESS;
    }
    
    
//order
    public String order(){
        orders = orderService.getOrders();
        return SUCCESS;
    }

    public String orderPreUpdate(){
        order = orderService.getOrder(order.getEoId());
        return SUCCESS;
    }


    //news
    public String newsManage(){
        newses = newsService.getNewss(null);
        return SUCCESS;
    }
    public String newsPreAdd(){
        return SUCCESS;
    }
    public String newsPreUpdate(){
        news = newsService.getNews(news.getEnId());
        return SUCCESS;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
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

    public List<EasybuyUser> getUsers() {
        return users;
    }

    public void setUsers(List<EasybuyUser> users) {
        this.users = users;
    }

    public EasybuyUser getUser() {
        return user;
    }

    public void setUser(EasybuyUser user) {
        this.user = user;
    }

    public EasybuyProductCategoryExpand getCategoryExpand() {
        return categoryExpand;
    }

    public void setCategoryExpand(EasybuyProductCategoryExpand categoryExpand) {
        this.categoryExpand = categoryExpand;
    }

    public EasybuyProductCategory getCategory() {
        return category;
    }

    public void setCategory(EasybuyProductCategory category) {
        this.category = category;
    }

    public List<EasybuyProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<EasybuyProductCategory> categories) {
        this.categories = categories;
    }

    public EasybuyProduct getProduct() {
        return product;
    }

    public void setProduct(EasybuyProduct product) {
        this.product = product;
    }

    public List<EasybuyProduct> getProducts() {
        return products;
    }

    public void setProducts(List<EasybuyProduct> products) {
        this.products = products;
    }

    public EasybuyNews getNews() {
        return news;
    }

    public void setNews(EasybuyNews news) {
        this.news = news;
    }

    public List<EasybuyNews> getNewses() {
        return newses;
    }

    public void setNewses(List<EasybuyNews> newses) {
        this.newses = newses;
    }

    public List<EasybuyOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<EasybuyOrder> orders) {
        this.orders = orders;
    }

    public EasybuyOrder getOrder() {
        return order;
    }

    public void setOrder(EasybuyOrder order) {
        this.order = order;
    }

    public EasybuyComment getComment() {
        return comment;
    }

    public void setComment(EasybuyComment comment) {
        this.comment = comment;
    }

    public List<EasybuyComment> getComments() {
        return comments;
    }

    public void setComments(List<EasybuyComment> comments) {
        this.comments = comments;
    }
}
