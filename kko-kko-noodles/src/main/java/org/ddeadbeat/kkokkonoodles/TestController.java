package org.ddeadbeat.kkokkonoodles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "24년 5월 15일 테스트";
	}
}
