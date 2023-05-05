package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장 타입을 포함했다
    private Address address;

    // Member 의 입장에서 주문은 하나의 회원이 여러개의 상품을 주문하기 때문에 일대다 관계가 된다.
    // mappedBy : 주인이 아닌 연관관계의 거울일 때 입력한다.
    // (mappedBy = "member") order 테이블에 있는 member 필드에 의해서 맵핑이 된거다. (읽기전용)
    // 값을 넣는다고해서 외래키가 변경되지 않는다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
