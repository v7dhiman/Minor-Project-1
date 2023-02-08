package com.example.minor1.request;

import com.example.minor1.models.AccountStatus;
import com.example.minor1.models.Student;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest
{
    @NotBlank
    private String name;

    @NotBlank
    private String contact;

    private String address;

    private String email;

    public Student to()
    {
        return Student.builder()
                .address(address)
                .contact(contact)
                .email(email)
                .name(name)
                .accountStatus(AccountStatus.ACTIVE)
                .build();
    }
}
