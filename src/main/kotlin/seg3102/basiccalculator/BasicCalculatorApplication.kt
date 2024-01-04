package seg3102.basiccalculator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BasicCalculator

fun main(args: Array<String>) {
	runApplication<BasicCalculator>(*args)
}
