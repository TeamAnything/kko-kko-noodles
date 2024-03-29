package org.ddeadbeat.kkokkonoodles.member.domain.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	@DisplayName("Null 이면 예외가 발생한다.")
	void failNull() {
		// given
		String nullName = null;

		// when & then
		assertThatThrownBy(() -> new Name(nullName))
			.isInstanceOf(NullPointerException.class)
			.hasMessageContaining("이름은 Null일 수 없습니다.");
	}

	@Test
	@DisplayName("2자 이상이 아닌 경우 예외가 발생한다.")
	void failUnderMinLength() {
		// given
		String underName = "a";

		// when & then
		assertThatThrownBy(() -> new Name(underName))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("2글자 이상이여야 합니다.");
	}

	@Test
	@DisplayName("10자 초과인 경우 예외가 발생한다.")
	void failOverMaxLength() {
		// given
		String overName = "aaaaaaaaaaa";

		// when & then
		assertThatThrownBy(() -> new Name(overName))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("10글자 이하여야 합니다.");
	}

	@Test
	@DisplayName("빈 문자열이거나 공백인 경우 예외가 발생한다.")
	void failIsBlank() {
		// given
		String blank = "    ";

		// when & then
		assertThatThrownBy(() -> new Name(blank))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("이름은 공백일 수 없습니다.");
	}

	@Test
	@DisplayName("양식에 맞는 경우 Name이 생성된다.")
	void success() {
		// given
		String success = "yejun";

		// when
		Name name = new Name(success);

		// then
		assertThat(name.getValue()).isEqualTo(success);
	}
}
