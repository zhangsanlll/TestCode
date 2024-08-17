package com.bit.ioc;


import com.bit.ioc.controller.UserController;
import com.bit.ioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class SpringIocApplication {

	public static void main(String[] args) {
		//获取Spring上下文对象
		ApplicationContext context = SpringApplication.run(SpringIocApplication.class,args);

/*		//使用Controller注解
		//根据bean类型,从Spring上下文中获取对象
		UserController userController = context.getBean(UserController.class);
		//根据bean名称,从Spring上下文中获取对象
		UserController userController1 =(UserController) context.getBean("userController");

		//根据bean名称 and 类型,从Spring上下文中获取对象
		UserController userController2 = context.getBean("userController",UserController.class);
		//使用对象
		//userController.sayHi();
		System.out.println(userController);
		System.out.println(userController1);
		System.out.println(userController2);*/

		//使用Service注解
/*		UserService userService = context.getBean(UserService.class);
		userService.sayHi();*/

		//使用Repository注解
/*		UserRepository userRepository = context.getBean(UserRepository.class);
		userRepository.sayHi();

		//使用Component注解
		UserComponent userComponent = context.getBean(UserComponent.class);
		userComponent.sayHi();

		//使用Configuration注解
		UserConfiguration userConfiguration = context.getBean(UserConfiguration.class);
		userConfiguration.sayHi();*/

		//将service类注入到controller类中
		UserController userController = context.getBean(UserController.class);
		userController.sayHi();
	}

}
