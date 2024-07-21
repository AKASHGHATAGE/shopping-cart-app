package com.prowings.shoppingcartapp.config;

import java.net.http.HttpClient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class RestTemplateConfig {
	
	@Value("${base_url}")
	private String url;
	
	
	@Bean
    public CloseableHttpClient httpClient() {
        return HttpClients.createDefault();
    }
	
	@Bean
	@Autowired
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(bufferingClientHttpRequestFactory());
//		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(url));
//		restTemplate.setErrorHandler(new MyRestTemplateResponseErrorHandler());
		
//		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//		interceptors.add(new RequestResponseLoggingInterceptor());
//		interceptors.add(new HeaderModificationInterceptor());
		
//		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		/*
		 * clientHttpRequestFactory.setHttpClient(HttpClient());
		 * clientHttpRequestFactory.setConnectionRequestTimeout(requestTimeout);
		 * clientHttpRequestFactory.setConnectTimeout(requestTimeout);
		 * clientHttpRequestFactory.setReadTimeout(requestTimeout);
		 */
		return clientHttpRequestFactory;
	}

	private BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory() {

		return new BufferingClientHttpRequestFactory(clientHttpRequestFactory());

	}
	

}
