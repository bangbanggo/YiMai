package edu.black.service.impl;

import edu.black.mapper.EasybuyProductCategoryMapper;
import edu.black.model.EasybuyProductCategory;
import edu.black.model.EasybuyProductCategoryExample;
import edu.black.model.EasybuyProductCategoryExpand;
import edu.black.service.CategoryService;
import edu.black.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    SqlSessionFactory factory = MybatisUtil.getFactory();

    @Override
    public EasybuyProductCategoryExpand getCategory() {
        SqlSession session = factory.openSession();
        EasybuyProductCategoryMapper mapper = session.getMapper(EasybuyProductCategoryMapper.class);
        List<EasybuyProductCategory> categories = mapper.selectByExample(null);
        session.close();
        EasybuyProductCategoryExpand categoryExpand = new EasybuyProductCategoryExpand(categories);
        return categoryExpand;
    }

    @Override
    public boolean insert(EasybuyProductCategory category) {
        SqlSession session = factory.openSession();
        EasybuyProductCategoryMapper mapper = session.getMapper(EasybuyProductCategoryMapper.class);
        boolean result = mapper.insertSelective(category)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public boolean delete(EasybuyProductCategory category) {
        SqlSession session = factory.openSession();
        EasybuyProductCategoryMapper mapper = session.getMapper(EasybuyProductCategoryMapper.class);
        boolean result = mapper.deleteByPrimaryKey(category.getEpcId())==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        return result;
    }

    @Override
    public boolean update(EasybuyProductCategory category) {
        SqlSession session = factory.openSession();
        EasybuyProductCategoryMapper mapper = session.getMapper(EasybuyProductCategoryMapper.class);
        boolean result = mapper.updateByPrimaryKeySelective(category)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        return result;
    }

    @Override
    public EasybuyProductCategory getCategory(int Categoryid) {
        SqlSession session = factory.openSession();
        EasybuyProductCategoryMapper mapper = session.getMapper(EasybuyProductCategoryMapper.class);
        EasybuyProductCategory category= mapper.selectByPrimaryKey(Categoryid);
        session.close();
        return category;
    }

    @Override
    public List<EasybuyProductCategory> getCategories(EasybuyProductCategory category) {
        SqlSession session = factory.openSession();
        EasybuyProductCategoryMapper mapper = session.getMapper(EasybuyProductCategoryMapper.class);

        if (category!=null){
            //do sth else
        }
        EasybuyProductCategoryExample example = new EasybuyProductCategoryExample();
        example.createCriteria().andEpcParentIdEqualTo(0);
        List<EasybuyProductCategory> categories= mapper.selectByExample(example);
        session.close();
        return categories;
    }
}
