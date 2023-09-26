package org.redninja;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PreAuthorize("hasAuthority('SCOPE_message.read')")
    @GetMapping("/messages")
    public String[] getMessages(JwtAuthenticationToken jwtAuthenticationToken) {
        System.out.println(jwtAuthenticationToken.getAuthorities());
        return new String[] {"Message 1", "Message 2", "Message 3"};
    }
}
