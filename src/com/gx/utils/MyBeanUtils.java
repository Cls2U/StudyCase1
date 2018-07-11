package com.gx.utils;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {
	
	private static final BigDecimal BIGDECIMAL_ZERO = new BigDecimal("0"); 
	public static <T> T populate(Class<T>beanClass,Map<String,String[]>properties){
		
		try{
			T bean = beanClass.newInstance();
			BigDecimalConverter bigDecimalConverter = new BigDecimalConverter(BIGDECIMAL_ZERO);
			DateConverter dateConverter = new DateConverter(null);
			dateConverter.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
			ConvertUtils.register(dateConverter, java.util.Date.class);
			ConvertUtils.register(bigDecimalConverter, java.math.BigDecimal.class);
			BeanUtils.populate(bean, properties);
			return bean;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
