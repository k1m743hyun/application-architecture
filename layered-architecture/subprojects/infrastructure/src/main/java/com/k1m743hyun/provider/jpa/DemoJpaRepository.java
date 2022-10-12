package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Demo;
import java.util.Optional;
import org.hibernate.mapping.Any;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoJpaRepository extends JpaRepository<Demo, Any> {

    Optional<Demo> findById(Long id);

    Optional<Demo> findByName(String name);
}
