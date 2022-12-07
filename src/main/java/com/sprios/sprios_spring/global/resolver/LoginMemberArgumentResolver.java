package com.sprios.sprios_spring.global.resolver;

import com.sprios.sprios_spring.domain.member.service.LoginService;
import com.sprios.sprios_spring.global.annotation.LoginMember;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@RequiredArgsConstructor
@Component
// 파라미터가 있을 때 원하는 값을 바인딩해주는 인터페이스
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {

  private final LoginService loginService;

  @Override
  // 현재 파라미터를 resolver가 지원하는지에 대한 boolean 리턴
  public boolean supportsParameter(MethodParameter methodParameter) {
    // 메소드의 파라미터가 LoginMember 어노테이션을 달고 있으면 resolver의 지원 대상이됨
    return methodParameter.hasParameterAnnotation(LoginMember.class);
  }

  @Override
  // 실제로 바인딩 할 객체를 return함
  public Object resolveArgument(
      MethodParameter methodParameter,
      ModelAndViewContainer modelAndViewContainer,
      NativeWebRequest nativeWebRequest,
      WebDataBinderFactory webDataBinderFactory)
      throws Exception {
    return loginService.getLoginMember();
  }
}
