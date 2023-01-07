package thuan.com.fa.demomvc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import thuan.com.fa.demomvc.service.ProductServiceImpl;

public class UniqueSerialValidator implements ConstraintValidator<UniqueSerial, String> {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0) {
			return true;
		}
		if (productServiceImpl == null) {
			return true;
		}
		boolean existSerial = !productServiceImpl.existSerial(value);
		return existSerial;
	}

	@Override
	public void initialize(UniqueSerial constraintAnnotation) {
	}

}
