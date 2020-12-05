package com.baeldung.ecommerce.User;

import com.baeldung.ecommerce.exception.UserException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class UserService {

    @Autowired
    UserRepositroy userRepository;

    public UserResponseDto userRegister(UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = new UserResponseDto();

        try {
            String usernameFromDto = userRequestDto.getUsername();
            String emailFromDto = userRequestDto.getEmail();
            String passwordFromDto = userRequestDto.getPassword();
            String gsmFromDto = userRequestDto.getGsm();
            User user = userRepository.findByEmailAndPassword(emailFromDto, passwordFromDto);
            if (user != null) {
                throw new UserException("email veya password hatali", new Exception());
            }
            user= new User();
            user.setUsername(usernameFromDto);
            user.setEmail(emailFromDto);
            user.setPassword(passwordFromDto);
            user.setGsm(gsmFromDto);
            user=userRepository.save(user);
            userResponseDto.setId(user.getId());
            userResponseDto.setUsername(user.getUsername());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setGsm(user.getGsm());
        } catch (Exception exception) {
            String hataMesaji = "email veya password hatali";
            userResponseDto.setHataMessage(hataMesaji);
            log.error(hataMesaji);
            return userResponseDto;

        }
        log.info("Kayıt basarili");
        return userResponseDto;


    }

        public UserResponseDto userGiris(UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = new UserResponseDto();
        try {
            String emailFromDto = userRequestDto.getEmail();
            String passwordFromDto = userRequestDto.getPassword();
            User user = userRepository.findByEmailAndPassword(emailFromDto, passwordFromDto);
            String email = user.getEmail();
            String password = user.getPassword();
            String username = user.getUsername();
            String gsm = user.getGsm();
            Long id = user.getId();
            if (user == null) {
                throw new UserException("email veya password hatali", new Exception());
            }
            userResponseDto.setEmail(email);
            userResponseDto.setPassword(password);
            userResponseDto.setGsm(gsm);
            userResponseDto.setUsername(username);
            userResponseDto.setId(id);

        } catch (Exception exception) {
            String hataMesaji = "email veya password hatali";
            userResponseDto.setHataMessage(hataMesaji);
            log.error(hataMesaji);
            return userResponseDto;
        }
        return userResponseDto;
    }
}
