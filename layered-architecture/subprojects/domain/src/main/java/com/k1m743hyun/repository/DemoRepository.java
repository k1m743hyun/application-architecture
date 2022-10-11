package com.k1m743hyun.repository;

import com.k1m743hyun.data.entity.Demo;
import java.util.Optional;

public interface DemoRepository {
    Optional<Demo> findById(int id);

    Optional<Demo> findByName(String name);
}
