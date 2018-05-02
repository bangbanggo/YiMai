package edu.black.service;

import edu.black.model.EasybuyProductCategory;
import edu.black.model.EasybuyProductCategoryExpand;

import java.util.List;

public interface CategoryService {
    public EasybuyProductCategoryExpand getCategory();
    public boolean insert(EasybuyProductCategory category);
    public boolean delete(EasybuyProductCategory category);
    public boolean update(EasybuyProductCategory category);
    public EasybuyProductCategory getCategory(int Categoryid);
    public List<EasybuyProductCategory> getCategories(EasybuyProductCategory category);
}
