//package crud.dogShelter.service;
//
//import crud.dogShelter.DTO.RegistrationOAuth2DTO.LocalUser;
//import crud.dogShelter.exceptions.registrationOAuth2Exceptions.UserAlreadyExistAuthenticationException;
//import crud.dogShelter.model.User;
//import org.springframework.security.oauth2.core.oidc.OidcIdToken;
//import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
//
//import java.util.Map;
//import java.util.Optional;
//
//public interface UserService {
//
//     User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;
//
//    User findUserByEmail(String email);
//
//    Optional<User> findUserById(Long id);
//
//    LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
//
//}
