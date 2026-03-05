package com.intern.tailorshop.domain;

import com.intern.tailorshop.enums.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;

    private String password;

//    @Enumerated(EnumType.STRING)
    private String role;

    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private TailorShop tailorShop;
}
