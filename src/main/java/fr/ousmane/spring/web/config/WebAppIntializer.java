package fr.ousmane.spring.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppIntializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		 webContext.register(WebMVCConfig.class);
		 webContext.setServletContext(container);
		 ServletRegistration.Dynamic registration = container.addServlet("TestSpringTest", new DispatcherServlet(webContext));
		 registration.setLoadOnStartup(1);
		 registration.addMapping("/");
		
	}

}
