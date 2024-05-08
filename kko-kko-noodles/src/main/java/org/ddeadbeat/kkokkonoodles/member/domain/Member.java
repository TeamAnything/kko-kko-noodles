package org.ddeadbeat.kkokkonoodles.member.domain;

import org.ddeadbeat.kkokkonoodles.member.domain.vo.Email;
import org.ddeadbeat.kkokkonoodles.member.domain.vo.Name;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private Name name;

	@Embedded
	private Email email;
}
