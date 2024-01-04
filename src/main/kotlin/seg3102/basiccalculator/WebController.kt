package seg3102.basiccalculator

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class WebController {
    @ModelAttribute
    fun addAttributes(model: Model) {
        model.addAttribute("error", "")
        model.addAttribute("val1", "")
        model.addAttribute("val2", "")
        model.addAttribute("res", "")
    }

    @RequestMapping("/")
    fun home(): String {
        return "home"
    }

    @GetMapping(value = ["/calc"])
    fun doCalc(
        // @RequestParam(value = "celsius", required = false) celsius: String,
        // @RequestParam(value = "fahrenheit", required = false) fahrenheit: String,
        @RequestParam(value = "operation", required = false) operation: String,
        @RequestParam(value = "val1", required = false) val1: String,
        @RequestParam(value = "val2", required = false) val2: String,
        // @RequestParam(value = "res", required = false) res: Number,
        model: Model
    ): String {
        var val1Value: Double
        var val2Value: Double
        var res: Double
        when (operation) {
            "sum" ->
                try {
                    val1Value = val1.toDouble()
                    val2Value = val2.toDouble()
                    res = val1Value + val2Value
                    model.addAttribute("val1", val1)
                    model.addAttribute("val2", val2)
                    model.addAttribute("res", String.format("%.2f", res))
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "ValueFormatError")
                    model.addAttribute("val1", val1)
                    model.addAttribute("val2", val2)
                }
            "difference" ->
                try {
                    val1Value = val1.toDouble()
                    val2Value = val2.toDouble()
                    res = val1Value - val2Value
                    model.addAttribute("val1", val1)
                    model.addAttribute("val2", val2)
                    model.addAttribute("res", String.format("%.2f", res))
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "ValueFormatError")
                    model.addAttribute("val1", val1)
                    model.addAttribute("val2", val2)
                }
            "product" ->
                try {
                    val1Value = val1.toDouble()
                    val2Value = val2.toDouble()
                    res = val1Value * val2Value
                    model.addAttribute("val1", val1)
                    model.addAttribute("val2", val2)
                    model.addAttribute("res", String.format("%.2f", res))
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "ValueFormatError")
                    model.addAttribute("val1", val1)
                    model.addAttribute("val2", val2)
                }
            "quotient" ->
                try {
                    val1Value = val1.toDouble()
                    val2Value = val2.toDouble()
                    res = val1Value / val2Value
                    model.addAttribute("val1", val1)
                    model.addAttribute("val2", val2)
                    model.addAttribute("res", String.format("%.2f", res))
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "ValueFormatError")
                    model.addAttribute("val1", val1)
                    model.addAttribute("val2", val2)
                }
            "reset" ->
                try {

                    model.addAttribute("val1", "")
                    model.addAttribute("val2", "")
                    model.addAttribute("res", "")
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "ValueFormatError")
                    model.addAttribute("val1", val1)
                    model.addAttribute("val2", val2)
                    model.addAttribute("res", "")
                }
            else -> {
                model.addAttribute("error", "OperationFormatError")
                model.addAttribute("val1", val1)
                model.addAttribute("val2", val2)
            }
        }
        return "home"
    }
}
