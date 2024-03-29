package org.ddeadbeat.kkokkonoodles.member.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Getter
public class Name {

	public static final int MIN_LENGTH = 2;
	public static final int MAX_LENGTH = 10;

	@Column(name = "name", nullable = false, length = MAX_LENGTH)
	private String value;

	public Name(final String value) {
		validateNull(value);
		final String trimmedValue = value.trim();
		validateBlank(trimmedValue);
		validateLength(trimmedValue);
		this.value = trimmedValue;
	}

	private void validateNull(final String value) {
		if (value == null) {
			throw new NullPointerException("이름은 Null일 수 없습니다.");
		}
	}

	private void validateLength(final String value) {
		if (value.length() < MIN_LENGTH) {
			throw new RuntimeException("2글자 이상이여야 합니다.");
		}

		if (value.length() > MAX_LENGTH) {
			throw new RuntimeException("10글자 이하여야 합니다.");
		}
	}

	private void validateBlank(final String value) {
		if (value.isBlank()) {
			throw new RuntimeException("이름은 공백일 수 없습니다.");
		}
	}
}
