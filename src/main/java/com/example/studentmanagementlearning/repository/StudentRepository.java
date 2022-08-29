// 🚩 Dada Ki Jay Ho 🚩


package com.example.studentmanagementlearning.repository;

import com.example.studentmanagementlearning.modesl.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
