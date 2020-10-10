package com.jrsf.myfood.order.entity;

import com.jrsf.myfood.order.dto.ClientOrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_client_order")
public class ClientOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "client_id", nullable = false)
    private Long idClient;

    private String name;

    public static ClientOrder create(ClientOrderDto clientOrderDto) {
        return new ModelMapper().map(clientOrderDto, ClientOrder.class);
    }
}
