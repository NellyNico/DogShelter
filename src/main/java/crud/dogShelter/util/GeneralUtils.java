//package crud.dogShelter.util;
//
//import crud.dogShelter.DTO.RegistrationOAuth2DTO.LocalUser;
//import crud.dogShelter.DTO.RegistrationOAuth2DTO.SocialProvider;
//import crud.dogShelter.DTO.RegistrationOAuth2DTO.UserInfo;
//import crud.dogShelter.model.Role;
//import crud.dogShelter.model.User;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class GeneralUtils {
//
//    public static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final Set<Role> roles) {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return authorities;
//    }
//
//    public static SocialProvider toSocialProvider(String providerId) {
//        for (SocialProvider socialProvider : SocialProvider.values()) {
//            if (socialProvider.getProviderType().equals(providerId)) {
//                return socialProvider;
//            }
//        }
//        return SocialProvider.LOCAL;
//    }
//
//    public static UserInfo buildUserInfo(LocalUser localUser) {
//        List<String> roles = localUser.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
//        User user = localUser.getUser();
//        return new UserInfo(user.getID().toString(), user.getDisplayName(), user.getEmail(), roles);
//    }
//}
