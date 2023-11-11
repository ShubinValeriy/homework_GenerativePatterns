import java.util.ArrayList;
import java.util.List;

public class Filter {
    private int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (int values : source){
            if (values >= treshold){
                logger.log("Элемент \"" + values + "\" проходит");
                result.add(values);
            } else {
                logger.log("Элемент \"" + values + "\" НЕ проходит");
            }
        }
        logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());
        return result;
    }
}
