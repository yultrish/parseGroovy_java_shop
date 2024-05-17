package prodMS.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prodMS.CRUD.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

