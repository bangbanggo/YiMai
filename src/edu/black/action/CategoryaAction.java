package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.model.EasybuyProductCategory;
import edu.black.service.CategoryService;
import edu.black.service.impl.CategoryServiceImpl;

public class CategoryaAction extends ActionSupport {
    private CategoryService categoryService = new CategoryServiceImpl();
    private EasybuyProductCategory category;
    public String delete(){
        if (categoryService.delete(category)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String add(){
        if (categoryService.insert(category)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String update(){
        if (categoryService.update(category)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public EasybuyProductCategory getCategory() {
        return category;
    }

    public void setCategory(EasybuyProductCategory category) {
        this.category = category;
    }
}
