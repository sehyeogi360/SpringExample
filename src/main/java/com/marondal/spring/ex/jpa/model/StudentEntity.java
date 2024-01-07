package com.marondal.spring.ex.jpa.model;



@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name="new_student")

public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp
	@Column(name = "createdAt", updatable = false)
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
