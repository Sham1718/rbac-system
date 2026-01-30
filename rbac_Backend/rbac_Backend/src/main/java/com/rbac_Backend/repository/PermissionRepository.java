package com.rbac_Backend.repository;

import com.rbac_Backend.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permissions,Long> {

    Optional<Permissions> findByName(String name);
}
