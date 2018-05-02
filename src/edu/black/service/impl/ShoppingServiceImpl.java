package edu.black.service.impl;

import edu.black.mapper.EasybuyOrderDetailMapper;
import edu.black.mapper.EasybuyOrderMapper;
import edu.black.model.EasybuyOrder;
import edu.black.model.EasybuyOrderDetail;
import edu.black.model.EasybuyOrderDetailExample;
import edu.black.model.EasybuyOrderExample;
import edu.black.service.ShoppingService;
import edu.black.util.DateUtil;
import edu.black.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.List;

public class ShoppingServiceImpl implements ShoppingService {
    private SqlSessionFactory factory = MybatisUtil.getFactory();


    @Override
    public boolean addProduct(int ProductId, String userid) {
        SqlSession session = factory.openSession();
        EasybuyOrderMapper orderMapper = session.getMapper(EasybuyOrderMapper.class);
        EasybuyOrderExample orderExample = new EasybuyOrderExample();
        orderExample.createCriteria().andEoStatusEqualTo(0);
        orderExample.createCriteria().andEoUserIdEqualTo(userid);
        List<EasybuyOrder> orders = orderMapper.selectByExample(orderExample);
        if (orders.size() == 1) {

        } else {
            EasybuyOrder order = new EasybuyOrder();
            order.setEoStatus(0);
            order.setEoUserId(userid);
            order.setEoUserName("");
            order.setEoUserAddress("");
            order.setEoCreateTime(new Date());
            orderMapper.insertSelective(order);
            orders = orderMapper.selectByExample(orderExample);
        }


        EasybuyOrderDetailMapper mapper = session.getMapper(EasybuyOrderDetailMapper.class);
        EasybuyOrderDetailExample detailExample = new EasybuyOrderDetailExample();
        detailExample.createCriteria().andEpIdEqualTo(ProductId);
        detailExample.createCriteria().andEoIdEqualTo(orders.get(0).getEoId());
        List<EasybuyOrderDetail> orderDetails = mapper.selectByExample(detailExample);
        EasybuyOrderDetail orderDetail = new EasybuyOrderDetail();
        orderDetail.setEpId(ProductId);
        orderDetail.setEoId(orders.get(0).getEoId());
        detailExample = new EasybuyOrderDetailExample();
        detailExample.createCriteria().andEoIdEqualTo(orders.get(0).getEoId());
        if (orderDetails.size() == 1) {
            orderDetail.setEodQuantity(orderDetails.get(0).getEodQuantity() + 1);
            mapper.updateByExample(orderDetail, detailExample);
        } else {
            orderDetail.setEodQuantity(1);
            mapper.insertSelective(orderDetail);
        }
        session.commit();
        session.close();
        return false;
    }

    @Override
    public boolean deleteProduct(int ProductId, String userId) {
        return false;
    }

    @Override
    public boolean reduceProduct(int ProductId, String userId) {
        return false;
    }

    @Override
    public boolean alterProduct(int ProductId, int quantity, String userId) {
        return false;
    }

    @Override
    public List<EasybuyOrderDetail> getItems(String userId) {
        return null;
    }
}