package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.domain.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDto userDto){

        this.firstName = userDto.firstName();
        this.lastName = userDto.lastName();
        this.balance = userDto.balance();
        this.document = userDto.document();
        this.userType = userDto.userType();
        this.email = userDto.email();
        this.password = userDto.password();
    }
}
