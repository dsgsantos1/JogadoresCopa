package com.example.lp4.orm;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 75)
	private String name;
	
	@NotNull
	@Size(min = 2, max = 20)
	private String nickname;
	
	@NotNull
	@Size(min = 2, max = 20)
	private String squad;
	
	@NotNull
	@Size(min = 2, max = 20)
	private String team;
	
	@Basic
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	@Basic
	@NotNull
	private int number;
	
	public Jogador() {}
	

	public Jogador(@NotNull @Size(min = 2, max = 75) String name, @NotNull @Size(min = 2, max = 20) String nickname,
			@NotNull @Size(min = 2, max = 20) String squad, @NotNull @Size(min = 2, max = 20) String team,
			Date birthday, @NotNull int number) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.squad = squad;
		this.team = team;
		this.birthday = birthday;
		this.number = number;
	}

	public int getAge() {
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(this.birthday);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, age);
		if (today.before(dateOfBirth)) {
			age--;
		}
		return age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSquad() {
		return squad;
	}

	public void setSquad(String squad) {
		this.squad = squad;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Jogador [id = " + id + ", nome = " + name + ", nascimento=" + sdf.format(birthday) + ", Apelido = " + nickname + 
				 ", Time = " + team + ", Seleção = " + squad + ", Nº =  " + number + "]";
	}


}
