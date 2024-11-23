package prajyot.academiaerp.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StudentLoginResponse(
        @JsonProperty("studentId")
        Long studentId,

//        @JsonProperty("firstName")
//        String firstName,
//
//        @JsonProperty("lastName")
//        String lastName,
//
//        @JsonProperty("email")
//        String email

        @JsonProperty("token")
        String token
) {
}
