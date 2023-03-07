package moon.calculate.calculate;


import moon.calculate.models.DataVO;
import moon.calculate.models.WarningVO;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICalculateService {
    WarningVO calculateresult(@RequestBody DataVO dataVO);
}
