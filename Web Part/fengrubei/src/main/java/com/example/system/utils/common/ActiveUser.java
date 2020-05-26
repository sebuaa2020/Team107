package com.example.system.utils.common;


import com.example.system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveUser {
    private User user;
    private Collection<String> roles;
    private Collection<String> permissions;



}
