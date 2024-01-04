package seg3102.calculator.controller

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping



@RestController 
@RequestMapping("calculator")
class CalculatorController{
    @GetMapping("/add/{number1}/{number2}")
    fun getSum(@PathVariable number1: Double, @PathVariable number2: Double )=(number1+number2)

    @GetMapping("/substract/{number1}/{number2}")
    fun getDifference(@PathVariable number1: Double, @PathVariable number2: Double )=(number1-number2)

    @GetMapping("/multiply/{number1}/{number2}")
    fun getProduct(@PathVariable number1: Double, @PathVariable number2: Double )=(number1*number2)
    
    @GetMapping("/divide/{number1}/{number2}")
    fun getQuoitent(@PathVariable number1: Double, @PathVariable number2: Double)=(number1/number2)

}

