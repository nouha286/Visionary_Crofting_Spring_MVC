package com.company.app.repository;

import com.company.app.model.CommandItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandItemRepository extends JpaRepository<CommandItem,Long>
{
}
