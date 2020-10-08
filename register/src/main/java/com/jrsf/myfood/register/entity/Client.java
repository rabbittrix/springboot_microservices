package com.jrsf.myfood.register.entity;

import com.jrsf.myfood.register.dto.ClientDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String password;

    public static Client create(ClientDto clientDto){
        return new ModelMapper().map(clientDto, Client.class);
    }
}
