package com.company.app.repository;

import com.company.app.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command,Long>
{
}
