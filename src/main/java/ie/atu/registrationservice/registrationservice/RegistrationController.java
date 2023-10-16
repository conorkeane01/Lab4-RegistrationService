package ie.atu.registrationservice.registrationservice;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {
    private NotificationServiceClient notificationServiceClient;

    @Autowired
    public RegistrationController(NotificationServiceClient notificationServiceClient) {
        this.notificationServiceClient = notificationServiceClient;
    }
    @PostMapping("/confirm")
    public String registerUser(@RequestBody UserDetails userDetails) {
        String notification = notificationServiceClient.someDetails(userDetails);
        String confirmationMessage = String.format("Received details for %s " + notification, userDetails.getName());
        return confirmationMessage;
    }

}

/*
@RestController
public class RegistrationController {
    @PostMapping("/register")
    public String registerUser(@RequestBody UserDetails userDetails) {
        return "Confirm register";
    }
}

 */