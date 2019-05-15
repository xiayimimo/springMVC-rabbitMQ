package com.tycho.test.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.tycho.config.DataSourceConst;
import com.tycho.config.DatabaseContextHolder;
import com.tycho.test.TestDynamicDataSourceDao;

@Repository("testDynamicDataSourceDao")
public class TestDynamicDataSourceDaoImpl extends JdbcDaoSupport implements TestDynamicDataSourceDao{

	
	
	@Resource
	public void setJb(JdbcTemplate jb) {
	  super.setJdbcTemplate(jb);
	     }
	
	@Override
	 public String getDataSource1Name() {
	        String sql = "";
	        try {
	            sql = "SELECT depart_name FROM `wheel_basics` GROUP BY depart_name";
	            return this.getJdbcTemplate().queryForObject(sql, String.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public String getDataSource2Name() {
	        String sql = "";
	        try {
	            // 切换到数据源datasource2
	            DatabaseContextHolder.setCustomerType(DataSourceConst.DB2);
	            sql = "SELECT depart_name FROM `wheel_basics` GROUP BY depart_name";
	            return this.getJdbcTemplate().queryForObject(sql, String.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // 恢复到默认数据源datasource1
	            DatabaseContextHolder.clearCustomerType();
	        }
	        return null;
	    }
}
