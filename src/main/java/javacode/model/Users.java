package javacode.model;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private int age;

    public Users(String log, String pass, int age){
        this.age=age;
        this.login=log;
        this.password=pass;
    }

}