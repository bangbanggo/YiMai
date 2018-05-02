package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.model.EasybuyComment;
import edu.black.service.CommentService;
import edu.black.service.impl.CommentServiceImpl;

public class CommentAction extends ActionSupport {
    private CommentService commentService = new CommentServiceImpl();
    private EasybuyComment comment;
    public String add(){
        if (commentService.insert(comment)){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    public String delete(){
        if (commentService.delete(comment)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String update(){
        if (commentService.update(comment)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }
    
    public EasybuyComment getComment() {
        return comment;
    }

    public void setComment(EasybuyComment comment) {
        this.comment = comment;
    }
}
