package com.project.SpringSecurity;

import java.beans.JavaBean;
import java.lang.System.Logger;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.xml.sax.helpers.XMLReaderFactory;


//public class Websecurity<HttpSecurity> extends Websecurity{
	private static final String NoOpPasswordEncoder = null;
	Logger logger = getLogger(Websecurity.class);
	

	
	public Object PasswordEncodergetPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	private Logger getLogger(Class<Websecurity> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void configureGlobal(Authentication auth) throws Exception {
		Object userDetailsService;
		//auth.userDetailsService(userDetailsService);
}
	protected void configure(HttpSecurity http) throws Exception {
		((Object) http).authorizeRequests()
				.antMatchers("/", "/index").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/welcome")
				.failureUrl("/login?error=true")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/login?logout=true")
				.invalidateHttpSession(true)
				.permitAll()
			.and()
				.csrf()
				.disable();
	}
}
