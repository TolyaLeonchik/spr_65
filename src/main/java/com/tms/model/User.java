package com.tms.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class User {             //POJO - Plane Old Java Object

//    @Null   // пройдет, если в поле null
//    @NotNull    // пройдет, если в поле не null
//    @Min(5)     //не меньше 5
////    @Max(10)    // НЕ БОЛЬШЕ 10
//@NotEmpty   // "" false - строка что то есть
//@NotBlank   // "" true - строка не пустая и не пустая
//@Pattern(regexp = "[A-z]{5}")
//@Negative
//@NegativeOrZero
//@Positive
//@PositiveOrZero
//@Digits(integer = 1, fraction = 10)     //TODO: check
//@AssertFalse    //проверка на false
//@AssertTrue     //проверка на true
//@Future
//@Past
//@FutureOrPresent
//@PastOrPresent
    private Integer id;     //нужен Объектный тип

    @Pattern(regexp = "[A-Z][A-z]*")
    private String firstName;
    private String secondName;
    private String login;
    private String password;

    @Min(18)
    @Max(120)
    private Integer age;

    @Email      //проверка на присутствие знака "@"
    private String email;
    private boolean isDeleted;
    private Date registrationDate;
}
