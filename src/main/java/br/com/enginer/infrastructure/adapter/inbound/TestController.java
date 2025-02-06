package br.com.enginer.infrastructure.adapter.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.enginer.domain.rule.dto.Model;
import br.com.enginer.infrastructure.reflection.ClassFinder;

@RestController
@RequestMapping("/teste")
public class TestController {

	@GetMapping
	public ResponseEntity<String> get() throws Exception {

		Model<?> model = (Model<?>) ClassFinder.findClassUsingClassLoader("EntityFour");

		System.out.println(model);

		return new ResponseEntity<String>("OK", HttpStatus.CREATED);

	}

}
