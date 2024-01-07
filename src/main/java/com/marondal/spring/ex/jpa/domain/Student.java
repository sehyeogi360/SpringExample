package com.marondal.spring.ex.jpa.domain;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
@Getter
@Table(name="new_student")
@Entity

public class Student {

		// id, 이름, 전화번호, 이메일, 장래희망
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		private String name;
		// 카멜 케이스 멤버변수 일경우 매칭 
		@Column(name="phoneNumber")
		private String phoneNumber;
		private String email;
		
		@Column(name="dreamJob")
		private String dreamJob;
		
		// 자동으로 현재 시간이 입력
		@UpdateTimestamp
		// update 될때는 수정되지 않는다.
		@Column(name="createdAt", updatable=false)
		private ZonedDateTime createdAt;
		
		@UpdateTimestamp
		@Column(name="updatedAt")
		private ZonedDateTime updatedAt;
}
