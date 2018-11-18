package qdu.lc.blogs;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(""))
				.paths(PathSelectors.any())
				.build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot中使用Swagger2构建RESTful APIs")
				.description("测试Demo")
				.termsOfServiceUrl("https://chaoaiqi.xyz")
				.contact("弑晓风")
				.version("1.0.0")
				.build();
	}
}
