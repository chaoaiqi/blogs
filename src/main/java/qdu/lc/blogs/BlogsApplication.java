package qdu.lc.blogs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
@MapperScan("qdu.lc.blogs.dao")
public class BlogsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BlogsApplication.class, args);
    }
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(BlogsApplication.class);
	  }
}