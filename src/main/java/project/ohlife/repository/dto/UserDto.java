package project.ohlife.repository.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.ohlife.domain.user.User;
import project.ohlife.domain.user.common.UserRole;
import project.ohlife.repository.dto.ArticleDto.ArticlesResponse;

public class UserDto {

  @Getter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class SignupRequest {

    @Email
    @NotBlank(message = "email은 필수 입력 값입니다.")
    private String email;
    @NotBlank(message = "password는 필수 입력 값입니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,20}$", message = "password는 영문, 숫자를 포함한 8자 이상 20자 이하로 입력해주세요(대소문자 구분은 없음).")
    private String password;
    @NotBlank(message = "nickname는 필수 입력 값입니다.")
    @Size(min = 2, max = 10, message = "nickname은 2자 이상 10자 이하로 입력해주세요.")
    private String nickname;
    @NotBlank(message = "phoneNumber는 필수 입력 값입니다.")
    @Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message = "phoneNumber는 010으로 시작하는 11자리 숫자로 입력해주세요.")
    private String phoneNumber;


    public User toEntity(String password) {
      return User.builder()
          .email(this.email)
          .password(password)
          .role(UserRole.USER)
          .nickname(nickname)
          .phoneNumber(phoneNumber)
          .build();
    }
  }

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class LoginRequest {

    @NotBlank(message = "email은 필수 입력 값입니다.")
    private String email;
    @NotBlank(message = "password는 필수 입력 값입니다.")
    private String password;
  }


  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class CertificationRequest {

    private String key;
    private String certificationNumber;
  }

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ProfileUpdateRequest {

    @NotBlank(message = "nickname는 필수 입력 값입니다.")
    @Size(min = 2, max = 10, message = "nickname은 2자 이상 10자 이하로 입력해주세요.")
    private String nickname;
    private String description;
  }

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ProfileResponse {

    private String nickname;
    private String profileImage;
    private String description;
  }

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class SearchUserResponse{

  private Long userId;
  private String nickname;
}


}
