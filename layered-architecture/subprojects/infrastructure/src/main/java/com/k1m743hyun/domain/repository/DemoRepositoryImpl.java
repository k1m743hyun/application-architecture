package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Demo;
import com.k1m743hyun.provider.jpa.DemoJpaRepository;
import com.k1m743hyun.repository.DemoRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DemoRepositoryImpl implements DemoRepository {

    private final DemoJpaRepository demoJpaRepository;

    @Override
    public Optional<Demo> findById(int id) {
        return demoJpaRepository.findById(id);
    }

    @Override
    public Optional<Demo> findByName(String name) {
        return demoJpaRepository.findByName(name);
    }
}