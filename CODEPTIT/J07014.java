package javacodeptit;

import java.io.*;
import java.util.*;

class WordSet {
    private final TreeSet<String> st = new TreeSet<>();

    public WordSet(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext()) st.add(sc.next().toLowerCase());
        sc.close();
    }

    public String union(WordSet other) {
        TreeSet<String> u = new TreeSet<>(st);
        u.addAll(other.st);
        StringBuilder sb = new StringBuilder();
        for (String x : u) sb.append(x).append(" ");
        return sb.toString().trim();
    }

    public String intersection(WordSet other) {
        TreeSet<String> i = new TreeSet<>(st);
        i.retainAll(other.st);
        StringBuilder sb = new StringBuilder();
        for (String x : i) sb.append(x).append(" ");
        return sb.toString().trim();
    }
}

public class J07014 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
