package com.pard.secondseminar.user.repository;


import com.pard.secondseminar.user.User;
import com.pard.secondseminar.user.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 저장소 역할 할거다
public class UserRepository {
    private static final Map<Integer, User> handong = new HashMap<>();

    //create
    public void save(UserDto userDto) {
        User u = User.builder()
                .studentName(userDto.getStudentName())
                .studentID(userDto.getStudentId())
                .build();
        handong.put(userDto.getStudentId(), u);

    }

    // read
    public UserDto findById(Integer studentId) {
        User user = handong.get(studentId);
        return UserDto.builder()
                .studentId(user.getStudentID())
                .studentName(user.getStudentName())
                .build();
    }


    public List<UserDto> findAll() {

        return handong.values().stream().
                map(user -> UserDto.builder()
                        .studentId(user.getStudentID())
                        .studentName(user.getStudentName())
                        .build()).toList();
    }


    // update
    public void update(Integer studentId, UserDto userDto) {
        User user = handong.get(studentId);
        user.setStudentID(userDto.getStudentId());
        user.setStudentName(userDto.getStudentName());
//        handong.put(userDto.getStudentId(), user);
    }

    //delete
    public void delete(Integer studentId) {
        handong.remove(studentId);
    }

}
