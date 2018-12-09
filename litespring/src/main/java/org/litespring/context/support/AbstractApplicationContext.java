package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;

public abstract class AbstractApplicationContext implements ApplicationContext {
private DefaultBeanFactory factory = null;
	
	/**
	 * 根据给定的路径读取 xml 文件，产生一个 ApplicationContext
	 * @param configFile
	 */
	public AbstractApplicationContext(String configFile) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
		Resource resource = this.getResourceByPath(configFile);
		xmlBeanDefinitionReader.loadBeanDefinitions(resource);
	}

	/**
	 * 根据 BeanId 获取 Bean 对象
	 */
	@Override
	public Object getBean(String beanId) {
		return factory.getBean(beanId);
	}
	
	public abstract Resource getResourceByPath(String configFile);
}
