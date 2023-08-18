package data.mappers;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
//import com.ultralesson.training.web.models.Customer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;

public class JSONDataMapper implements DataMapper {

    @Override
    public <T> T map(String file, String key, Class tClass) {
        Gson gson = new Gson();
        try {
            Map jsonMap = gson.fromJson(new FileReader(file), Map.class);
            LinkedTreeMap jsonElement = (LinkedTreeMap) jsonMap.get(key);
            if(Objects.isNull(jsonElement)) throw new FileNotFoundException();
            return (T) gson.fromJson(gson.toJson(jsonElement), tClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("Failed to find data for key %s in file %s or filepath %s itself is wrong", key, file, file));
        }
    }

}