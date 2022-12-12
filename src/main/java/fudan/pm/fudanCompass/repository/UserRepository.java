package fudan.pm.fudanCompass.repository;

import fudan.pm.fudanCompass.entity.Article;
import fudan.pm.fudanCompass.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<Article> {
    User findUserByUsername(String username);
    User findUserById(Long userId);
}
