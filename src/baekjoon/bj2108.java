package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class bj2108 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        double mean = getArithmeticMean(list);
        int median = getMedian(list);
        int mode = getMode(list);
        int range = getRange(list);

        bw.write(Math.round(mean) + "\n");
        bw.write(median + "\n");
        bw.write(mode + "\n");
        bw.write(range + "\n");





        bw.flush();
    }

    //산술평균
    public static double getArithmeticMean(List<Integer> list) {
        if(list.size() == 1) return list.get(0);

        double cnt = list.size();
        /*
        * 두가지 방식으로 생성되는 스트림의 타입을 기억하자
        * */
        // Stream<List<Integer>> s = Stream.of(list);
        // Stream<Integer> s = list.stream();
        Integer sum = list.stream().reduce(0, Integer::sum);
        return sum / cnt;
    }

    //중앙값
    public static int getMedian(List<Integer> list) {
        if(list.size() == 1) return list.get(0);

        Collections.sort(list);

        int size = list.size();

        return list.get( size / 2);
    }


    //최빈값
    public static int getMode(List<Integer> list) {
        if(list.size() == 1) return list.get(0);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i),0) + 1);
        }

        //LinkedHashMap이 아닌 HashMap으로 할경우 정렬이 되지 않는다
        //Map은 기본적으로 key와 value로만 이루어져 있기 때문 여기에 순서를 더한 LinkedHashMap으로 Supplier를 선언해야 의도되로 value기준으로 정렬이 된다.
        Map<Integer,Integer> sorted = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int rst = 0;

        List<Integer> keyList = map.keySet().stream().collect(Collectors.toList());
        int maxValue = map.values().stream().max(Comparator.naturalOrder()).get();
        if(maxValue == 1) {
            //모든 요소가 1개씩 들어있다는 뜻이므로..
           Collections.sort(keyList);
           rst = keyList.get(1);
        } else {
            int maxValueCnt = 0;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if( entry.getValue() == maxValue) maxValueCnt++;
            }

            // 2번씩 들어간 요소가 1개이상 존재한다면 비교하여 두번째 작은 key return
            if( maxValueCnt > 1) {
                List<Integer> maxKeyList = new ArrayList<>();
                for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    if(entry.getValue() == maxValue) {
                        maxKeyList.add(entry.getKey());
                    }
                }

                Collections.sort(maxKeyList);

                rst = maxKeyList.get(1);

            }
            // 2번씩 들어간 요소가 1개만 존재한다면 해당 key return
            if( maxValueCnt == 1) {
                rst = sorted.keySet().iterator().next();
            }


        }


        return rst;

    }

    //범위
    public static int getRange(List<Integer> list){
        if(list.size() == 1) return 0;

        int min = list.stream().reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a);
        int max = list.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);

        return max - min;
    }


}
