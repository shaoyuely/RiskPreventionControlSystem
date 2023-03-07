package moon.calculate.calculate;

import moon.calculate.models.DataVO;
import moon.calculate.models.WarningVO;
import moon.calculate.tools.Rules;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/org/calculate")
public class CalculateServiceImpl implements ICalculateService {

    @RequestMapping(value = "/calculateresult", method = RequestMethod.POST)
    public WarningVO calculateresult(@RequestBody DataVO dataVO) {
        Rules rules = new Rules(dataVO);
        WarningVO warningVO = rules.warning();
//        warningVO.GetMessage();
        return warningVO;
    }
}
