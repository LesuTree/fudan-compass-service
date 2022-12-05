package fudan.pm.fudanCompass.entity;

import fudan.pm.fudanCompass.dto.request.ArticleRequest;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String title;
    private String tags;

    @Column(columnDefinition = "text")
    private String content;

    @Column(columnDefinition = "bigint default 0")
    private Long likeNum;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime createTime;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime updateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "article_comment",
            joinColumns = {@JoinColumn(name = "article_id")}, inverseJoinColumns = {@JoinColumn(name = "comment_id")})
    private List<Comment> comments;

    public void update(ArticleRequest request) {
        if (!ObjectUtils.isEmpty(request.getTags()))
            tags = String.join(",", request.getTags());
        if (!ObjectUtils.isEmpty(request.getTitle()))
            title = request.getTitle();
        if (!ObjectUtils.isEmpty(request.getContent()))
            content = request.getContent();
    }

}
