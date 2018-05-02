package edu.black.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.black.model.EasybuyProduct;
import edu.black.service.ProductService;
import edu.black.service.impl.ProductServiceImpl;

public class ProductAction extends ActionSupport {
    private ProductService productService = new ProductServiceImpl();
    private EasybuyProduct product;
    public String delete(){
        if (productService.delete(product)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String add(){
        if (productService.insert(product)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String update(){
        if (productService.update(product)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public EasybuyProduct getProduct() {
        return product;
    }

    public void setProduct(EasybuyProduct product) {
        this.product = product;
    }
}
