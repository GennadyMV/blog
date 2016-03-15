package net.devstudy.blog.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devstudy.blog.service.impl.ServiceManager;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServiceManager.getInstance(sce.getServletContext());
		LOGGER.info("Application started");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServiceManager.getInstance(sce.getServletContext()).destroy();
		LOGGER.info("Application destroyed");
	}
}