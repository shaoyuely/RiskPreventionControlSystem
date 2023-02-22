package moon.calculate.tools;

/**
 * 枚举工具类
 */
public class Tools {

    /**
     * 数额计量单位
     */
    public enum Unit {
        BITS,
        TEN_THOUSAND,
        MILLION,
        TEN_MILLION,
        BILLION
    }

    /**
     * 预警等级
     */
    public enum EarlyWarningLevel {
        NONE,
        LEVEL_ONE,
        LEVEL_TWO,
        LEVEL_THREE,
        LEVEL_FOUR
    }

    /**
     * 预警等级
     */
    public enum EarlyWarningProcessing {
        NONE,
        LEVEL_ONE,
        LEVEL_TWO,
        LEVEL_THREE,
        LEVEL_FOUR
    }

    public static String getEarlyWarningLevelDescription(String type) {
        if (type.equals("LEVEL_ONE")) {
            return "Ⅰ级预警";
        } else if (type.equals("LEVEL_TWO")) {
            return "Ⅱ级预警";
        } else if (type.equals("LEVEL_THREE")) {
            return "Ⅲ级预警";
        } else if (type.equals("LEVEL_FOUR")) {
            return "Ⅳ级预警";
        }
        return "无预警";
    }

    public static String getEarlyWarningProcessingDescription(String type) {
        if (type.equals("LEVEL_ONE")) {
            return "继续观察，按季向管理层提交监控报告";
        } else if (type.equals("LEVEL_TWO")) {
            return "扩大直接融资占比 按月向管理层提交监控报告\n降低负债率";
        } else if (type.equals("LEVEL_THREE")) {
            return "召开风控会议，启动监控系统\n减少赊销 加大远期支付工具运用 停止对外担保";
        } else if (type.equals("LEVEL_FOUR")) {
            return "启动违约债务处置流程，加大现金储备量\n要求被担保单位提供反担保，全力保障经营安全";
        }
        return "";
    }
}
