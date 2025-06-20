package stream_api.que8;

import flatmap.service.LibraryService;

import java.time.temporal.JulianFields;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/***
 Problem Statement: User Performance Merger
 You are given:
 Two different data sources of usernames (List<String>) — from web and mobile.
 Two corresponding score sources (List<Integer>) — web scores and mobile scores.
 Your task is to:
 Combine usernames from both sources into one stream.
 Combine scores from both sources into one stream.
 */
public class UserScoreMerger {
    public static void main(String[] args) {
        List<String>webUsers=List.of("Sumit","Shreeraj");
        List<String>mobileUsers=List.of("Raj","Indrajeet");

        List<Integer>webScore=List.of(88,86);
        List<Integer>mobileScore=List.of(90,88);

        List<String>allUser= Stream.concat(webUsers.stream(),mobileUsers.stream()).toList();

        List<Integer>allScores=List.of(webScore,mobileScore)
                .stream().flatMap(List::stream)
                .toList();

        List<String>mergerResult= IntStream.range(0,Math.min(allUser.size(),allScores.size()))
                .mapToObj(i->"all users "+allUser.get(i)+ " all score "+allScores.get(i))
                .toList();

        mergerResult.forEach(System.out::println);
    }
}
