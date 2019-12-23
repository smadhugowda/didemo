package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJMSSource;

@Configuration
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
//@PropertySources({
//	@PropertySource("classpath:datasource.properties"),
//	@PropertySource("classpath:jms.properties"),
//})
public class PropertyConfig {
	
	//@Autowired
	//Environment env;
	
	@Value("${guru.username}")
	String user;
	
	@Value("${guru.password}")
	String password;
	
	@Value("${guru.dburl}")
	String url;
	
	@Value("${guru.jms.username}")
	String jmsuser;
	
	@Value("${guru.jms.password}")
	String jmspassword;
	
	@Value("${guru.jms.dburl}")
	String jmsurl;
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		//fakeDataSource.setUser(env.getProperty("JAVA_HOME"));
		fakeDataSource.setUser(user);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}
	
	@Bean
	public FakeJMSSource FakeJMSSource() {
		FakeJMSSource jmsSource = new FakeJMSSource();
		jmsSource.setUser(jmsuser);
		jmsSource.setPassword(jmspassword);
		jmsSource.setUrl(jmsurl);
		return jmsSource;
	}
	
	/*
	 * @Bean public static PropertySourcesPlaceholderConfigurer properties() {
	 * PropertySourcesPlaceholderConfigurer configurer = new
	 * PropertySourcesPlaceholderConfigurer(); return configurer; }
	 */
}
