package api.dto;

import jdk.nashorn.internal.objects.annotations.Getter;


public class ValidUserRequest {

    private String full_name;
    private String email;
    private String password;
    private boolean generate_magic_link;

}
