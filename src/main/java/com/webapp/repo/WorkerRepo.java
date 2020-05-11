package com.webapp.repo;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long>
{
    Worker findByName(String name);
    List<Worker> findByRole(Role role);
    Worker findWorkerById(Long id);
    List<Worker> findByDepartment (Department department);
}
