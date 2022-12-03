package site.movieasy.server.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.movieasy.server.converter.OauthProviderConverter;

@Getter
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column에서 nullable=False로 주면, DB에는 Null이 들어갈 수 없지만, 엔티티의 필드에는 Null을 넣는게 가능하다.
    // 그래서 NotNull 어노테이션을 사용하여 DB, 엔티티에 Null이 들어가는 것을 막았다.
    @Column(name = "nickname")
    @NotNull
    private String nickname;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "oauth_provider")
    @NotNull
    @Convert(converter = OauthProviderConverter.class)
    private OauthProvider oauthProvider;

    @Builder
    public User(Long id, String nickname, String email, String password, OauthProvider oauthProvider) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.oauthProvider = oauthProvider;
    }
}

