package pl.coderslab.charity.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static String username() {

        if(SecurityContextHolder.getContext().getAuthentication().getName().contains("admin"))
        {
            return "%";
        }
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
