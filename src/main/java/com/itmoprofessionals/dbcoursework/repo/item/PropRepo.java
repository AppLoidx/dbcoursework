package com.itmoprofessionals.dbcoursework.repo.item;

import com.itmoprofessionals.dbcoursework.domain.item.Prop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PropRepo extends JpaRepository<Prop, UUID> {
}
