package com.tycho.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

//配置多数据源
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		// 决定当前寻找的数据源key,对应于datasource.xml的dataSource1与dataSource2
		return DatabaseContextHolder.getCustomerType();
	}

}
