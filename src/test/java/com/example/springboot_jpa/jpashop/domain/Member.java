package com.example.springboot_jpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // Order 테이블에 있는 member 필드에 의해 매핑이 됨
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
