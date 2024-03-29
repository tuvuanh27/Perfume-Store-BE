package com.tuhungkien.ecommerce.mapper;

import com.tuhungkien.ecommerce.domain.Review;
import com.tuhungkien.ecommerce.domain.User;
import com.tuhungkien.ecommerce.dto.RegistrationRequest;
import com.tuhungkien.ecommerce.dto.review.ReviewRequest;
import com.tuhungkien.ecommerce.dto.user.UserRequest;
import com.tuhungkien.ecommerce.dto.user.UserResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.tuhungkien.ecommerce.util.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void convertUserRequestDtoToEntity() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName(FIRST_NAME);
        userRequest.setEmail(USER_EMAIL);

        User user = modelMapper.map(userRequest, User.class);
        assertEquals(userRequest.getFirstName(), user.getFirstName());
        assertEquals(userRequest.getEmail(), user.getEmail());
    }

    @Test
    public void convertRegistrationRequestDtoToEntity() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName(FIRST_NAME);
        registrationRequest.setEmail(USER_EMAIL);
        registrationRequest.setPassword(USER_PASSWORD);

        User user = modelMapper.map(registrationRequest, User.class);
        assertEquals(registrationRequest.getFirstName(), user.getFirstName());
        assertEquals(registrationRequest.getEmail(), user.getEmail());
        assertEquals(registrationRequest.getPassword(), user.getPassword());
    }

    @Test
    public void convertReviewToEntity() {
        ReviewRequest reviewRequest = new ReviewRequest();
        reviewRequest.setAuthor(FIRST_NAME);
        reviewRequest.setMessage("Hello World!");

        Review review = modelMapper.map(reviewRequest, Review.class);
        assertEquals(reviewRequest.getAuthor(), review.getAuthor());
        assertEquals(reviewRequest.getMessage(), review.getMessage());
    }

    @Test
    public void convertToResponseDto() {
        User user = new User();
        user.setFirstName(FIRST_NAME);
        user.setEmail(USER_EMAIL);

        UserResponse userRequestDto = modelMapper.map(user, UserResponse.class);
        assertEquals(user.getFirstName(), userRequestDto.getFirstName());
        assertEquals(user.getEmail(), userRequestDto.getEmail());
    }
}
