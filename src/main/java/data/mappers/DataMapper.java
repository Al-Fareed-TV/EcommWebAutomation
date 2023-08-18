package data.mappers;

public interface DataMapper {
   <T> T map(String filename, String key, Class tClass);
}
