package com.russow.entity;

import com.russow.validation.annotation.FieldMatch;
import com.russow.validation.annotation.UpdateDateConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

/**
 * UserInfo.
 *
 * @author Sergei_Russov
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldMatch.List({
        @FieldMatch(first = "email", second = "confirmedEmail", message = "The email and confirmedEmail fields must match")
})
public class UserInfo {

    @Pattern(regexp = "(([a-z]+\\d+)|(\\d+[a-z]+))[a-z\\d]*")
    private String name;
    @Size(min = 6)
    private String password;
    private String email;
    private String confirmedEmail;
    @UpdateDateConstraint
    private OffsetDateTime updateDatetime;
}
