package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException{
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == key) {
                rsl = i;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = new String[]{"red", "blue"};
        try {
            System.out.println(indexOf(value, "red"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}