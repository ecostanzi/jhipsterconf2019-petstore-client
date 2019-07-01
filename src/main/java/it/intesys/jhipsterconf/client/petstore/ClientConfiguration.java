package it.intesys.jhipsterconf.client.petstore;

import it.intesys.jhipsterconf.client.ExcludeFromComponentScan;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@Configuration
@ExcludeFromComponentScan
@EnableConfigurationProperties
public class ClientConfiguration {

  @Value("${petstore.security.jwt.username:}")
  private String jwtUsername;

  @Value("${petstore.security.jwt.password:}")
  private String jwtPassword;

  @Bean
  @ConditionalOnProperty(name = "petstore.security.jwt.username")
  public BasicAuthRequestInterceptor jwtRequestInterceptor() {
    return new BasicAuthRequestInterceptor(this.jwtUsername, this.jwtPassword);
  }

}
