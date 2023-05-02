package com.demospring.messageapi.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "El parametro msg es obligatorio")
    private String msg;
    private int timeToLifeSec;
    @Column(name = "target")
    @NotNull(message = "El parametro to es obligatorio")
    private String to;
    @Column(name = "source")
    @NotNull(message = "El parametro from es obligatorio")
    private String from;

}
