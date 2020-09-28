package com.russow.entity;

import com.russow.validation.annotation.EmailConstraint;
import com.russow.validation.annotation.UpdateDateConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

/**
 * UserInfo.
 *
 * @author Sergei_Russov
 */
@Data
@EmailConstraint
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Pattern(regexp = "[a-zA-Z].{5,}")
    private String name;
    @Pattern(regexp = "[a-zA-Z]+")
    private String password;
    private String email;
    private String confirmedEmail;
    @UpdateDateConstraint
    private OffsetDateTime updateDatetime;
}
