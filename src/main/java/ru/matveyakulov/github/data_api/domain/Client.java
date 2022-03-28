package ru.matveyakulov.github.data_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
@RequiredArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client_id", cascade = {CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Order> orders = new HashSet<>();

    @NotBlank(message = "Заполните имя")
    @Length(max = 255, message = "Слишком длинное имя, превышает 255 символов")
    @Column
    private String name;

    @NotNull
    @Column
    private Date date_of_create;
}
