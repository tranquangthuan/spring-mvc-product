package thuan.com.fa.demomvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueSerialValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueSerial {
	public String message() default "There is already product with this serial number!";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}
