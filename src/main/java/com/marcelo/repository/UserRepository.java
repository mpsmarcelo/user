package com.marcelo.repository;

import com.marcelo.entity.Usuario;
import org.hibernate.tool.schema.UniqueConstraintSchemaUpdateStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long> {
}
