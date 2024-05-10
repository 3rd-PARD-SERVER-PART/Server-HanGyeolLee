package com.pard.hw5.oauth;

import com.pard.hw5.user.dto.user.UserCreateDTO;
import com.pard.hw5.user.dto.user.UserCreateGoogleDTO;
import com.pard.hw5.user.repo.UserRepo;
import com.pard.hw5.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepo userRepo;
    private final UserService userService;

    public PrincipalOauth2UserService(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }
    // loadUser는 구글에서 유저 프로필 받아옴
    @Override
    public OAuth2User loadUser(
            OAuth2UserRequest oAuth2UserRequest)
            throws OAuth2AuthenticationException {

        log.info("google 에서 받아온 userRequest:"+oAuth2UserRequest );
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        log.info("oauth에서 받아온 정보 : "+ oAuth2User.getAttributes());

        userService.createUser(toDTO(oAuth2User));

        return super.loadUser(oAuth2UserRequest);
    }
    public UserCreateDTO toDTO(OAuth2User oAuth2User){
        String name = oAuth2User.getAttribute("name").toString();
        String email = oAuth2User.getAttribute("email").toString();
        return new UserCreateDTO(name, email);
    }
}
