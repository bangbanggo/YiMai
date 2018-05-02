package edu.black.service;

import edu.black.model.EasybuyOrder;
import edu.black.model.EasybuyOrderDetail;

import java.util.List;

public interface OrderService {
    public boolean generateOrder(List<EasybuyOrderDetail> details,String userid);
    public List<EasybuyOrder> getOrders();
    public EasybuyOrder getOrder(int orderid);
}
