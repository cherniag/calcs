package com.gc.calcs;

import clojure.lang.Keyword;
import clojure.lang.PersistentVector;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        com.gc.calcs.Parser parser = new  com.gc.calcs.Parser();
        Object o = parser.parse(" 10  /  5  + 1");
        System.out.println(o);
        HashMap hashMap = new HashMap();
        hashMap.put("x1", "5");
        Object r = parser.calc((PersistentVector)o, hashMap);
        System.out.println(r);
    }

//    public static double traverse(PersistentVector pv, double result) {
//        Object[] objects = pv.arrayFor(pv.count());
//        Keyword k = (Keyword) objects[0];
//        switch (k.getName()) {
//            case "DIV": return getOperand((PersistentVector) objects[1]) / getOperand((PersistentVector) objects[2]);
//        }
//
//
//        System.out.println(pv);
//        Iterator iterator = pv.iterator();
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//            if (next instanceof PersistentVector) {
//                result = traverse((PersistentVector) next, result);
//            } else if (next instanceof Keyword) {
//                Keyword keyword = (Keyword) next;
//                if(keyword.getName().equals("OPERAND")){
//                    return getOperand(pv);
//                }
//                System.out.println("Keyword " + pv);
////                switch (keyword.getName()){
////                    case "DIV":
////                }
//                if (keyword.getName().equals("VAR")) {
//                    keyword.call();
//                }
//            }
//        }
//        return result;
//    }
//
//    private static double getOperand(PersistentVector pv) {
//        return Double.valueOf(pv.arrayFor(pv.count())[1].toString());
//    }
}
