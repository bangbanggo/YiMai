package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.model.EasybuyNews;
import edu.black.service.NewsService;
import edu.black.service.impl.NewsServiceImpl;

public class NewsAction extends ActionSupport {
    private NewsService newsService = new NewsServiceImpl();
    private EasybuyNews news;
    public String delete(){
        if (newsService.delete(news)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String add(){
        if (newsService.insert(news)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String update(){
        if (newsService.update(news)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }
}
