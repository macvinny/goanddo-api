package br.com.macvinny.goanddo.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank
    private String name;

    @CNPJ
    @NotBlank
    @Column(unique = true)
    private String cnpj;

    @NotBlank
    private String description;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    private boolean active;
}
