package org.ddeadbeat.kkokkonoodles.member.domain.vo;

import java.util.regex.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Email {

	private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$";

	@Column(name = "email", nullable = false, unique = true)
	private String value;

	public Email(final String value) {
		validateNull(value);
		validateRegex(value);
		this.value = value;
	}

	private void validateNull(final String value) {
		if (value == null) {
			throw new NullPointerException("이메일은 null일 수 없습니다.");
		}
	}

	private void validateRegex(final String value) {
		if (!Pattern.matches(EMAIL_REGEX, value)) {
			throw new RuntimeException("이메일 형식을 확인해주세요.");
		}
	}
}
