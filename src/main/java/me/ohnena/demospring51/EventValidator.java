package me.ohnena.demospring51;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // ValidationUtils를 사용하여 처리...
        // : target에 대하여 검증작업을 한 결과, title이라는 필드가 empty라면 에러정보를 errors를 담을 거다...
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "title is not empty?!");

        //아래와같이 직접 처리도 가능...
//        Event event = (Event)target;
//        if (event.getTitle() == null) {
//            errors.reject("this is an error code");
//            //errors.rejectValue(...)
//        }

    }
}
