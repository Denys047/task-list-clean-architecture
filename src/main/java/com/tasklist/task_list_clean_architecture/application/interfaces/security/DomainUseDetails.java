package com.tasklist.task_list_clean_architecture.application.interfaces.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface DomainUseDetails extends UserDetails {

    UUID getUserModelId();

}
