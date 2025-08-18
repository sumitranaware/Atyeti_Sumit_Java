package com.example.user_service.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreatedEvent {
    private Long id;

    private String email;

}
