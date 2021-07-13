package com.evz.school.utils;

import com.evz.school.vo.ConfigVO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MathNumGame {

    /**
     * 生成加减法
     *
     * @param num
     * @return
     */
    public List<String> genTypeA(int num) {
        List<String> list = new ArrayList<String>();

        int k = 0;

        while (k < num) {
            int a = random();
            int b = random();
            String symbol = genSymbol();

            if (symbol.equals("-")) {
                if (a - b >= 0) {
                    list.add(a + " - " + b + " =  ");
                    k++;
                }
            } else {
                if (a + b <= 20) {
                    list.add(a + " + " + b + " =  ");
                    k++;
                }
            }

        }

        return list;
    }

    public List<String> genTypeB(int num) {
        List<String> list = new ArrayList<String>();

        int k = 0;

        while (k < num) {
            int a = random();
            int b = random();
            String symbol = genSymbol();
            String site = genSite();

            if (symbol.equals("-")) {
                if (a - b >= 0) {
                    if (site.equals("first")) {
                        list.add("(   ) - " + b + " = " + (a - b));
                    } else if (site.equals("second")) {
                        list.add(a + "  - (   ) = " + (a - b));
                    }
                    k++;
                }
            } else {
                if (a + b <= 20) {
                    if (site.equals("first")) {
                        list.add("(   ) + " + b + " = " + (a + b));
                    } else if (site.equals("second")) {
                        list.add(a + "  + (   ) = " + (a + b));
                    }
                    k++;
                }
            }
        }
        return list;
    }

    public List<String> genTypeC(int num) {
        List<String> list = new ArrayList<String>();

        int k = 0;

        while (k < num) {
            int a = random();
            int b = random();
            int c = random();
            String symbol = genSymbol();
            if (symbol.equals("-")) {
                if (a - b - c >= 0) {
                    list.add(a + " - " + b + " - " + c + " =  ");
                    k++;
                }
            } else {
                if (a + b + c <= 20) {
                    list.add(a + " + " + b + " + " + c + " =  ");
                    k++;
                }
            }

        }
        return list;
    }

    /**
     * 生成乘除法
     *
     * @param num
     * @return
     */
    public List<String> genTypeD(int num) {
        List<String> list = new ArrayList<String>();

        int k = 0;

        while (k < num) {
            int a = random();
            int b = random();
            String symbol = genSymbol();

            if (symbol.equals("-")) {
                if (a - b >= 0) {
                    list.add(a + " X " + b + " =  ");
                    k++;
                }
            } else {
                if (a + b <= 20) {
                    list.add(a + " ÷ " + b + " =  ");
                    k++;
                }
            }

        }

        return list;
    }


    private int random() {
        int d = (int) (Math.random() * ConfigVO.maxnum);
        return d;
    }

    private String genSymbol() {
        if (Math.random() > 0.5) {
            return "-";
        }
        return "+";
    }

    private String genSite() {
        if (Math.random() > 0.5) {
            return "first";
        }
        return "second";
    }

    public String print2File(/*List<String> list*/) {

        List<String> listA = this.genTypeA(ConfigVO.typeA);
        List<String> listB = this.genTypeB(ConfigVO.typeB);
        List<String> listC = this.genTypeC(ConfigVO.typeC);
        List<String> listD = this.genTypeD(ConfigVO.typeD);

        List<String> totalList = new ArrayList<String>();
        totalList.addAll(listA);
        totalList.addAll(listB);
//		totalList.addAll(listC);
        totalList.addAll(listD);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String filename = "计算100题" + sdf.format(new Date());

        StringBuffer sf = new StringBuffer();

        sf.append("\t\t\t\t" + sdf.format(new Date()) + "的数学作业                 姓名：瑞  ");
        sf.append(System.getProperty("line.separator")).append("</br>");
        sf.append(System.getProperty("line.separator")).append("</br>");
        /**
         * 转换为数组
         */
        String[][] toFileFormat = new String[25][4];

        int t = 0;
        for (int k = 0; k < 4; k++) {
            for (int p = 0; p < 25; p++) {
                toFileFormat[p][k] = totalList.get(t);
                t++;
            }
        }

        for (int m = 0; m < 25; m++) {
            for (int n = 0; n < 4; n++) {
                sf.append(toFileFormat[m][n]);
                if (n < 3) {
                    sf.append("\t\t").append("</br>");
                }
            }
            sf.append(System.getProperty("line.separator")).append("</br>");
            sf.append(System.getProperty("line.separator")).append("</br>");
        }

        System.out.println(sf.toString());

        return sf.toString();
        /*File file = new File("./" + filename + ".txt");
        try (FileOutputStream fop = new FileOutputStream(file)) {
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = sf.toString().getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    public static void main(String[] args) {
        MathNumGame g = new MathNumGame();
        List<String> listA = g.genTypeA(ConfigVO.typeA);
        List<String> listB = g.genTypeB(ConfigVO.typeB);
        List<String> listC = g.genTypeC(ConfigVO.typeC);
        List<String> listD = g.genTypeD(ConfigVO.typeD);

        List<String> totalList = new ArrayList<String>();
        totalList.addAll(listA);
        totalList.addAll(listB);
//		totalList.addAll(listC);
        totalList.addAll(listD);

//        g.print2File(totalList);
    }
}
