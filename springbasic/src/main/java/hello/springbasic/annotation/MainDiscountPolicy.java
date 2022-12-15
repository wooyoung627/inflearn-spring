package hello.springbasic.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

// 문자로는 컴파일 시점에 오류를 알 수 없다.
// 어노테이션을 정의해서 사용하는 것을 추천
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
