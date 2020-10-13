package com.jrsf.myfood.login.message;

import com.jrsf.myfood.login.dto.LoginDto;
import com.jrsf.myfood.login.entity.Login;
import com.jrsf.myfood.login.repository.LoginRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class LoginReceiveMessage {
    private final LoginRepository loginRepository;

    @Autowired
    public LoginReceiveMessage(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    @RabbitListener(queues = {"${register.login.rabbitmq.queue}"})
    public void receiveMessage(@Payload LoginDto loginDto){
        System.out.println(loginDto);
        loginRepository.save(new Login(null, loginDto.getEmail(), loginDto.getPassword()));
    }

}
