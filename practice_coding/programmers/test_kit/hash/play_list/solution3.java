package practice_coding.programmers.test_kit.hash.play_list;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public class Song implements Comparable<Song> {
        int id;
        int play;
        String genre;

        Song(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }

        String getGenre() {
            return genre;
        }

        @Override
        public int compareTo(Song o) {
            return this.play == o.play ? this.id - o.id : o.play - this.play;
        }
    }

    private int getPlaySum(List<Song> songs) {
        int sum = 0;
        for (Song song : songs) {
            sum += song.play;
        }
        return sum;
    }

    public int[] solution(String[] genres, int[] plays) {

        return IntStream.range(0, genres.length)
        .mapToObj(i -> new Song(i, plays[i], genres[i]))
        .collect(Collectors.groupingBy(Song::getGenre))
        .entrySet().stream()
        .sorted((a, b) -> getPlaySum(b.getValue()) - getPlaySum(a.getValue()))
        .flatMap(x -> x.getValue().stream().sorted().limit(2))
        .mapToInt(x -> x.id).toArray();
    }
}