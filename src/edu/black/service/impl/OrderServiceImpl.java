package edu.black.service.impl;

import edu.black.mapper.EasybuyOrderDetailMapper;
import edu.black.mapper.EasybuyOrderMapper;
import edu.black.mapper.EasybuyProductMapper;
import edu.black.mapper.EasybuyUserMapper;
import edu.black.model.*;
import edu.black.service.OrderService;
import edu.black.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    SqlSessionFactory factory = MybatisUtil.getFactory();
    @Override
    public boolean generateOrder(List<EasybuyOrderDetail> details, String userid) {
        SqlSession session = factory.openSession();

        //获得用户信息
        EasybuyUserMapper userMapper =  session.getMapper(EasybuyUserMapper.class);
        EasybuyUserExample userExample = new EasybuyUserExample();
        userExample.createCriteria().andEuUserIdEqualTo(userid);
        List<EasybuyUser> users = userMapper.selectByExample(userExample);
        if (users.size()!=1) return false;
        EasybuyUser user = users.get(0);

        //生成订单
        EasybuyOrderMapper orderMapper = session.getMapper(EasybuyOrderMapper.class);
        EasybuyOrderExample orderExample = new EasybuyOrderExample();
        EasybuyOrder order = new EasybuyOrder();
        order.setEoStatus(0);
        order.setEoUserId(userid);
        order.setEoUserName(user.getEuUserName());
        order.setEoUserAddress(user.getEuAddress());
        order.setEoCreateTime(new Date());
        order.setEoCost(0f);
        orderMapper.insertSelective(order);

        //获得订单编号
        EasybuyOrderExample orderExample1 = new EasybuyOrderExample();
        orderExample.createCriteria().andEoUserIdEqualTo(userid);
        orderExample.createCriteria().andEoStatusEqualTo(0);
        EasybuyOrder resultOrder = orderMapper.selectByExample(orderExample).get(0);

        //丰富订单详情信息
        EasybuyProductMapper productMapper = session.getMapper(EasybuyProductMapper.class);
        EasybuyProductExample productExample = new EasybuyProductExample();
        for (EasybuyOrderDetail det:details){
            productExample.createCriteria().andEpIdEqualTo(det.getEpId());
            EasybuyProduct product = productMapper.selectByExample(productExample).get(0);
            det.setEodCost(product.getEpPrice()*det.getEodQuantity());
            det.setEoId(resultOrder.getEoId());
        }


        //生成订单详情,获得订单编号,获得对应商品信息,插入订单详情信息
        EasybuyOrderDetailMapper detailMapper = session.getMapper(EasybuyOrderDetailMapper.class);
        Float count = 0f;
        for (EasybuyOrderDetail det:details){
            detailMapper.insertSelective(det);
            count+=det.getEodCost();
        }

        //更新订单信息
        orderExample = new EasybuyOrderExample();
        orderExample.createCriteria().andEoIdEqualTo(resultOrder.getEoId());
        EasybuyOrder newOrder = new EasybuyOrder();
        newOrder.setEoCost(count);
        newOrder.setEoStatus(1);
        boolean result = orderMapper.updateByExampleSelective(newOrder, orderExample)==1?true:false;
        if (result){
            session.commit();
        }else{
            session.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<EasybuyOrder> getOrders() {
        SqlSession session =factory.openSession();
        EasybuyOrderMapper mapper = session.getMapper(EasybuyOrderMapper.class);
        List<EasybuyOrder> result = mapper.selectByExample(null);
        session.close();
        return result;
    }

    @Override
    public EasybuyOrder getOrder(int orderid) {
        SqlSession session =factory.openSession();
        EasybuyOrderMapper mapper = session.getMapper(EasybuyOrderMapper.class);
        EasybuyOrder result = mapper.selectByPrimaryKey(orderid);
        session.close();
        return result;
    }
}
