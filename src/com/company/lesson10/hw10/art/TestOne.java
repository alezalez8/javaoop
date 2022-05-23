package com.company.lesson10.hw10.art;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class TestOne {
    private Map<String, String[]> ascii = new HashMap<String, String[]>();

    private String[] a = { "   #   ", "  # #  ", " #   # ", "#     #", "#######","#     #","#     #"};
    private String[] b = { "###### ", "#     #", "#     #", "###### ", "#     #","#     #","###### " };
    private String[] c = { " ##### ", "#     #", "#      ", "#      ", "#      " , "#     #"," ##### "};
    private String[] d = { "###### ", "#     #", "#     #", "#     #", "#     #" , "#     #","###### "};
    private String[] e = { "#######", "#      ", "#      ", "#####  ", "#      ", "#      ","#######"};
    private String[] f = { "#######", "#      ", "#      ", "#####  ", "#      " , "#      ","#      "};
    private String[] g = { " ##### ", "#     #", "#      ", "#  ####", "#     #" , "#     #"," ##### "};
    private String[] h = { "#     #", "#     #", "#     #", "#######", "#     #" , "#     #","#     #"};
    private String[] i = { "###", " # ", " # ", " # ", " # " , " # ","###"};
    private String[] j = { "      #", "      #", "      #", "      #", "#     #", "#     #"," ##### "};
    private String[] k = { "#    #", "#   # ", "#  #  ", "###   ", "#  #  ", "#   # ","#    #" };
    private String[] l = { "#      ", "#      ", "#      ", "#      ", "#      " , "#      ","#######"};
    private String[] m = { "#     #", "##   ##", "# # # #", "#  #  #", "#     #" , "#     #","#     #"};
    private String[] n = { "#     #", "##    #", "# #   #", "#  #  #", "#   # #", "#    ##","#     #"};
    private String[] o = { " ##### ", "#     #", "#     #", "#     #", "#     #" , "#     #"," ##### "};
    private String[] p = { "###### ", "#     #", "#     #", "###### ", "#      " , "#      ","#      "};
    private String[] q = { " ##### ", "#     #", "#     #", "#     #", "#   # #" , "#    # "," #### #"};
    private String[] r = { "###### ", "#     #", "#     #", "###### ", "#   #  " , "#    # ","#     #"};
    private String[] s = { " ##### ", "#     #", "#      ", " ##### ", "      #", "#     #"," ##### "};
    private String[] t = { "#######", "   #   ", "   #   ", "   #   ", "   #   ", "   #   ","   #   " };
    private String[] u = { "#     #", "#     #", "#     #", "#     #", "#     #" , "#     #"," ##### "};
    private String[] v = { "#     #", "#     #", "#     #", "#     #", " #   # " , "  # #  ","   #   "};
    private String[] w = { "#     #", "#  #  #", "#  #  #", "#  #  #", "#  #  #", "#  #  #"," ## ## " };
    private String[] x = { "#     #", " #   # ", "  # #  ", "   #   ", "  # #  " , " #   # ","#     #"};
    private String[] y = { "#     #", " #   # ", "  # #  ", "   #   ", "   #   " , "   #   ","   #   "};
    private String[] z = { "#######", "     # ", "    #  ", "   #   ", "  #    " , " #     ","#######"};

    public TestOne() {
        super();
        // TODO Auto-generated constructor stub
    }

    private <T> void getCurrClassFieldsByType(Class<T> type) {
        TestOne tr = new TestOne();
        Class<? extends Object> tempCl = tr.getClass();

        ArrayList<Field> fields = Arrays.stream(tempCl.getDeclaredFields())
                .filter(f -> (f.getType().getSimpleName().equals(type.getSimpleName())))
                .collect(Collectors.toCollection(ArrayList::new));

        for (Field field : fields) {
            String fName = field.getName();
            field.setAccessible(true);
            try {
                String[] fVal = (String[]) field.get(tr);
                ascii.put(fName, fVal);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public List<List<String>> StrToAsciiConvert(String text) {

        getCurrClassFieldsByType(String[].class);
        String[] lets = text.toLowerCase().split("");
        List<List<String>> listResStr = new ArrayList<List<String>>();

        for (int i = 0; i < 7; i++) {
            List<String> temp = new ArrayList<String>();
            for (String letr : lets) {
                if (ascii.containsKey(letr)) {
                    temp.add(ascii.get(letr)[i]);
                } else if(letr.equals(" ")) {
                    temp.add("   ");
                }
            }
            listResStr.add(temp);
        }
        return listResStr;
    }

    public void asciiOut(List<List<String>> asciiRes){
        asciiRes.forEach(str -> {
            System.out.println();
            str.forEach(el ->System.out.print(el+"   "));
        });


    }

    @Override
    public String toString() {
        return "StrToAsciiConv [ascii=" + ascii + ", a=" + Arrays.toString(a) + ", b=" + Arrays.toString(b) + ", c="
                + Arrays.toString(c) + ", d=" + Arrays.toString(d) + ", e=" + Arrays.toString(e) + ", f="
                + Arrays.toString(f) + ", g=" + Arrays.toString(g) + ", h=" + Arrays.toString(h) + ", i="
                + Arrays.toString(i) + ", j=" + Arrays.toString(j) + ", k=" + Arrays.toString(k) + ", l="
                + Arrays.toString(l) + ", m=" + Arrays.toString(m) + ", n=" + Arrays.toString(n) + ", o="
                + Arrays.toString(o) + ", p=" + Arrays.toString(p) + ", q=" + Arrays.toString(q) + ", r="
                + Arrays.toString(r) + ", s=" + Arrays.toString(s) + ", t=" + Arrays.toString(t) + ", u="
                + Arrays.toString(u) + ", v=" + Arrays.toString(v) + ", w=" + Arrays.toString(w) + ", x="
                + Arrays.toString(x) + ", y=" + Arrays.toString(y) + ", z=" + Arrays.toString(z) + "]";
    }
}
