package edu.black.service;

import edu.black.model.EasybuyOrderDetail;

import java.util.List;

public interface ShoppingService {
    public boolean addProduct(int ProductId,String userId);
    public boolean deleteProduct(int ProductId,String userId);
    public boolean reduceProduct(int ProductId,String userId);
    public boolean alterProduct(int ProductId,int quantity,String userId);

    public List<EasybuyOrderDetail> getItems(String userId);
}
