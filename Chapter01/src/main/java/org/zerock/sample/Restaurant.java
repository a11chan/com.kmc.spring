package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component //스프링 코어에서 관리하는 객체임을 지정
@Data //Lombok: setters 메서드/생성자/toString() 등을 자동으로 생성
public class Restaurant {
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	//Restaurant 객체는 Chef 객체를 필요로 한다(의존한다).
	//onMethod_ 속성은 메서드에 추가할 애너테이션을 지정
	//@Autowired는 Chef객체를 chef에 자동으로 주입
}