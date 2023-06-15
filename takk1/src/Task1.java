import java.util.function.Function;

public class Task1 implements Function<String[],String[]>{
    @Override
    public String[] apply(String[] strings) {
        int i = 0;
        int j;
        char[] array;
        while (i != strings.length){
            j = 0;
            strings[i] = new StringBuilder(strings[i]).reverse().toString();
            array = strings[i].toCharArray();
            while (j != strings[i].length()){
                if (array[j] != 32) {
                    if ((j == 0) || ((array[j-1] == 32) && (array[j]>=91))){
                        array[j] -= 32;
                    }
                    else if ((int)(strings[i].charAt(j))<91){
                        array[j] += 32;
                    }
                }
                j++;
            }
            strings[i] = String.valueOf(array);
            i++;
        }
        return strings;
    }
}
