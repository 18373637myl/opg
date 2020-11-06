import java.util.*;

public class Matrix {
    Map<Character,Integer> map = new HashMap<>();

    public Matrix(){                               //构造终结符的枚举关系
        this.map.put('+',0);
        this.map.put('*',1);
        this.map.put('i',2);
        this.map.put('(',3);
        this.map.put(')',4);
        this.map.put('#',5);
    }

    int[][] arr = {{'>','<','<','<','>','>'},      //算符分析矩阵
                    {'>','>','<','<','>','>'},
                    {'>','>',0,0,'>','>'},
                    {'<','<','<','<','=',0},
                    {'>','>',0,0,'>','>'},
                    {'<','<','<','<',0,0}};

}
