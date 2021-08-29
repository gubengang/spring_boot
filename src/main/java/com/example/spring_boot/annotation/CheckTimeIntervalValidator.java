package com.example.spring_boot.annotation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 * @author gubengang
 * @create 2021-08-15 20:25
 */
public class CheckTimeIntervalValidator implements ConstraintValidator<CheckTimeInterval,Object> {
    private String startTime;
    private String endTime;
    @Override
    public void initialize(CheckTimeInterval constraintAnnotation) {
        this.startTime = constraintAnnotation.startTime();
        this.endTime =constraintAnnotation.endTime();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(startTime==null||endTime==null){
            return true;
        }

        BeanWrapper beanWrapper = new BeanWrapperImpl(o);
        Object start = beanWrapper.getPropertyValue(startTime);
        Object end = beanWrapper.getPropertyValue(endTime);

        int result = ((Date) end).compareTo((Date) start);
        if(result>=0){
            return true;
        }

        return false;
    }
}
