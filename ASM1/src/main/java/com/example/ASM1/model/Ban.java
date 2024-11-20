package com.example.ASM1.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Ban")
@ToString
public class Ban {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "SoThich")
    private String soThich;
    @Column(name = "GioiTinh")
    private Integer gioiTinh;

}
