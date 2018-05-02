package edu.black.service.impl;

import edu.black.mapper.EasybuyProductMapper;
import edu.black.model.EasybuyProduct;
import edu.black.model.EasybuyProductExample;
import edu.black.service.ProductService;
import edu.black.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    SqlSessionFactory factory = MybatisUtil.getFactory();
    

    @Override
    public boolean insert(EasybuyProduct product) {
        SqlSession session = factory.openSession();
        EasybuyProductMapper mapper = session.getMapper(EasybuyProductMapper.class);
        boolean result = mapper.insertSelective(product)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public boolean delete(EasybuyProduct product) {
        SqlSession session = factory.openSession();
        EasybuyProductMapper mapper = session.getMapper(EasybuyProductMapper.class);
        boolean result = mapper.deleteByPrimaryKey(product.getEpId())==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        return result;
    }

    @Override
    public boolean update(EasybuyProduct product) {
        SqlSession session = factory.openSession();
        EasybuyProductMapper mapper = session.getMapper(EasybuyProductMapper.class);
        boolean result = mapper.updateByPrimaryKeySelective(product)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        return result;
    }

    @Override
    public EasybuyProduct getProduct(int Productid) {
        SqlSession session = factory.openSession();
        EasybuyProductMapper mapper = session.getMapper(EasybuyProductMapper.class);
        EasybuyProduct product= mapper.selectByPrimaryKey(Productid);
        session.close();
        return product;
    }

    @Override
    public List<EasybuyProduct> getProducts(EasybuyProduct product) {
        SqlSession session = factory.openSession();
        EasybuyProductMapper mapper = session.getMapper(EasybuyProductMapper.class);
        EasybuyProductExample example = new EasybuyProductExample();
        if (product!=null){
            //do sth else
            example.createCriteria().andEpcIdEqualTo(product.getEpcId());
        }
        List<EasybuyProduct> categories= mapper.selectByExample(example);
        session.close();
        return categories;
    }

    @Override
    public List<EasybuyProduct> getHistory(List<Integer> ids) {
        SqlSession session = factory.openSession();
        EasybuyProductMapper mapper = session.getMapper(EasybuyProductMapper.class);
        EasybuyProductExample example = new EasybuyProductExample();
        example.createCriteria().andEpIdIn(ids);
        List<EasybuyProduct> categories= mapper.selectByExample(example);
        session.close();
        return categories;
    }

    @Override
    public List<EasybuyProduct> getProducts(int clasParentId) {
        SqlSession session = factory.openSession();
        EasybuyProductMapper mapper = session.getMapper(EasybuyProductMapper.class);
        List<EasybuyProduct> categories= mapper.selectProductByClassId(clasParentId);
        session.close();
        return categories;
    }
}
