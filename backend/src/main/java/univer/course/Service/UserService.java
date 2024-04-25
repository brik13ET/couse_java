package univer.course.Service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    UserDetailsManager detailsManager;

    public Optional<String> login(User user)
    {
        var userDetails = detailsManager.loadUserByUsername(user.getUsername());
        if (userDetails == null)
            return Optional.empty();
        if (!userDetails.getPassword().equals(user.getPassword()))
            return Optional.empty();
        return Optional.empty();
    }
}
