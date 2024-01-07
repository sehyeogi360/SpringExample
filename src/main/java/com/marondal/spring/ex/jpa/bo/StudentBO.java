package com.marondal.spring.ex.jpa.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.jpa.dao.StudentRepository;
import com.marondal.spring.ex.jpa.model.StudentEntity;

@Service
public class StudentBO {
	
	@Autowired
	private StudentRepository studentRepostioty;
	
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = studentRepository.save(
				StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimeStamp가 있으면 생략해도 됨
				// .updatedAt(ZonedDateTime.now()) // @UpdateTimeStamp가 있으면 생략해도 됨
				.build());
		return student;
	}
	
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(7).orElse(null);
		if (student != null) {
			student = student.toBuilder() // toBuilder는 기존값 유지하고 일부만 변경
					.dreamJob(dreamJob).build();

			student = studentRepository.save(student);
		}
		return student;
	}
	
	public void deleteStudentById(int id) {
		// 방법1)
		StudentEntity student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			studentRepository.delete(student);
		}
				
		// 방법2)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
}
