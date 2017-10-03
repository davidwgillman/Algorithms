import java.util.ArrayList;

public class CountShuffle{
    public static void main(String[] args){
        
        KnuthShuffle shuffler = new KnuthShuffle();
        ArrayList<Object[]> permutations = new ArrayList<Object[]>();
        int[] occurrences = new int[23];
        
        Object[] a = new Object[] {1,2,4,3};
        permutations.add(a);        
        Object[] b = new Object[] {1,3,2,4};
        permutations.add(b);
        Object[] c = new Object[] {1,3,4,2};
        permutations.add(c);
        Object[] d = new Object[] {1,4,2,3};
        permutations.add(d);
        Object[] e = new Object[] {1,4,3,2};
        permutations.add(e);
        Object[] f = new Object[] {2,1,3,4};
        permutations.add(f);
        Object[] g = new Object[] {2,1,4,3};
        permutations.add(g);
        Object[] h = new Object[] {2,3,1,4};
        permutations.add(h);
        Object[] i = new Object[] {2,3,4,1};
        permutations.add(i);
        Object[] j = new Object[] {2,4,1,3};
        permutations.add(j);
        Object[] k = new Object[] {2,4,3,1};
        permutations.add(k);
        Object[] l = new Object[] {3,1,2,4};
        permutations.add(l);
        Object[] m = new Object[] {3,1,4,2};
        permutations.add(m);
        Object[] n = new Object[] {3,2,1,4};
        permutations.add(n);
        Object[] o = new Object[] {3,2,4,1};
        permutations.add(o);
        Object[] p = new Object[] {3,4,1,2};
        permutations.add(p);
        Object[] q = new Object[] {3,4,2,1};
        permutations.add(q);
        Object[] r = new Object[] {4,1,2,3};
        permutations.add(r);
        Object[] s = new Object[] {4,1,3,2};
        permutations.add(s);
        Object[] t = new Object[] {4,2,1,3};
        permutations.add(t);
        Object[] u = new Object[] {4,2,3,1};
        permutations.add(u);
        Object[] v = new Object[] {4,3,1,2};
        permutations.add(v);
        Object[] x = new Object[] {4,3,2,1};
        permutations.add(x);
        
        for(int count_1 = 0; count_1 <= 2400; count_1++){
            Object[] target = new Object[] {1,2,3,4};
            shuffler.shuffle(target);
            
            for(int count_2 = 0; count_2 < 23; count_2++){
                
                Object[] temp = permutations.get(count_2);
                
                for(int count_3 = 0; count_3 < 4; count_3++){
                    if(target[count_3] == temp[count_3] && count_3 == 3){
                        occurrences[count_2] += 1;
                        break;
                    }
                    else if(target[count_3] != temp[count_3]){
                        break;
                    }
                }
            }
        }
        
        for(int count_4 = 0; count_4 < 23; count_4++){
            Object[] temp_2 = permutations.get(count_4);
            System.out.println("Occurrences of {" + temp_2[0] + ", " + temp_2[1] + ", " +  temp_2[2] +", " +  temp_2[3] + "} : " + occurrences[count_4]);
        }
        
    }   
}

