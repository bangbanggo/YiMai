package edu.black.service;


import edu.black.model.EasybuyProduct;

import java.util.List;

public interface ProductService {
    public boolean insert(EasybuyProduct product);
    public boolean delete(EasybuyProduct product);
    public boolean update(EasybuyProduct product);
    public EasybuyProduct getProduct(int Categoryid);
    public List<EasybuyProduct> getProducts(EasybuyProduct product);
    public List<EasybuyProduct> getProducts(int  clasParentId);
    public List<EasybuyProduct> getHistory(List<Integer> ids);
}
