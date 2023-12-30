package project.ohlife.domain.user;

import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.ohlife.domain.user.common.UserBase;
import project.ohlife.domain.user.common.UserRole;

@Entity
@Getter
@AllArgsConstructor
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class User extends UserBase {

  private String nickname;

  private String profileImage;

  private String description;
  @Column(unique = true)
  private String phoneNumber;

  private Boolean isVerified; // 이메일 인증 및 휴대폰 인증 여부 저장


  @Builder
  public static User createUser(String email, String password, UserRole role, String nickname,String phoneNumber) {
    return User.builder()
        .email(email)
        .password(password)
        .role(role)
        .nickname(nickname)
        .phoneNumber(phoneNumber)
        .build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return phoneNumber != null && Objects.equals(phoneNumber, user.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneNumber);
  }
}
