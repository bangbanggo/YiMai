package edu.black.model;

import java.util.ArrayList;
import java.util.List;

public class EasybuyProductCategoryExpand extends EasybuyProductCategory{

    private List<EasybuyProductCategoryExpand> categories = null;

    private EasybuyProductCategory em = null;

    public EasybuyProductCategoryExpand(){

    }

    public EasybuyProductCategoryExpand(EasybuyProductCategory category){
        this.setEpcId(category.getEpcId());
        this.setEpcName(category.getEpcName());
        this.setEpcParentId(category.getEpcParentId());
        this.setEpcAction(category.getEpcAction());
    }

    public EasybuyProductCategoryExpand(List<EasybuyProductCategory> list){
        categories = new ArrayList<>();
        //取一级菜单
        for (EasybuyProductCategory category:list){
            if (category.getEpcParentId()==0){
                categories.add(new EasybuyProductCategoryExpand(category));
//                list.remove(category);//list遍历时不允许增删除
            }
        }
        //取二级菜单
        for (EasybuyProductCategory category:list){
            for (EasybuyProductCategoryExpand parent:categories){
                if (category.getEpcParentId()==parent.getEpcId()){
                    if (parent.getCategories()==null){
                        parent.setCategories(new ArrayList<>());
                    }
                    parent.getCategories().add(new EasybuyProductCategoryExpand(category));
//                    list.remove(category);
                    break;
                }
            }
        }
        //取三级菜单,侧边新建菜单
        for (EasybuyProductCategory category:list){
            for (EasybuyProductCategoryExpand parent:categories){
                if (parent.getCategories()!=null){
                    for (EasybuyProductCategoryExpand sub:parent.getCategories()){
                        if (sub.getEpcId()==category.getEpcParentId()){
                            sub.setEm(category);
                            break;
                        }
                    }
                }
            }
        }
    }

    public List<EasybuyProductCategoryExpand> getCategories() {
        return categories;
    }

    public void setCategories(List<EasybuyProductCategoryExpand> categories) {
        this.categories = categories;
    }

    public EasybuyProductCategory getEm() {
        return em;
    }

    public void setEm(EasybuyProductCategory em) {
        this.em = em;
    }
}
