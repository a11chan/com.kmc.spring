package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.sample.Restaurant;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //오류 발생시 buildPath 추가
//└>테스트에 필요한 Runner 클래스 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//└>스프링 빈을 등록하는 설정파일의 경로 지정
@Log4j //오류 발생시 pom.xml > log4g > <scope>주석처리
//└>로거 객체 생성(Logger)
public class SampleTests {
	@Setter(onMethod_ = { @Autowired })
	private Restaurant restaurant;
	@Test //단위 테스트의 대상임을 지정, testExist()를 실행하여 JUnit 테스트 진행
	public void testExist() {

		assertNotNull(restaurant);
		//restaurant 변수가 null아 아니면 true반환 후 아래 코드 실행
		log.info(restaurant);
		log.info("----------------------------------");
		log.info(restaurant.getChef());

	}

}