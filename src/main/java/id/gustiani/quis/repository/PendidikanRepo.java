package id.gustiani.quis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.gustiani.quis.model.entity.Pendidikan;

public interface PendidikanRepo extends JpaRepository<Pendidikan, Integer> {
}
