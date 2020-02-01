import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        class Song implements Comparable<Song> {
            int id;
            int play;

            Song(int id, int play) {
                this.id = id;
                this.play = play;
            }

            @Override
            public int compareTo(Song o) {
                return this.play == o.play ? this.id - o.id : o.play - this.play;
            }
        }

        class Genre implements Comparable<Genre> {
            ArrayList<Song> songs = new ArrayList<>();

            void addSong(Song song) {
                songs.add(song);
            }

            int getPlaySum() {
                int sum = 0;
                for (Song song : songs) {
                    sum += song.play;
                }
                return sum;
            }

            @Override
            public int compareTo(Genre o) {
                return o.getPlaySum() - this.getPlaySum();
            }
        }

        HashMap<String, Genre> hashMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i], new Genre());
            }
            hashMap.get(genres[i]).addSong(new Song(i, plays[i]));
        }

        // sort genre(by sum of play times)
        ArrayList<Genre> sortedGenre = new ArrayList<>(hashMap.values());
        Collections.sort(sortedGenre);
        // sort songs(by play times and id) for every genres
        for (Genre entry : sortedGenre) {
            Collections.sort(entry.songs);
        }

        // choose max two songs from same genre
        ArrayList<Integer> answer = new ArrayList<>();
        for (Genre entry : sortedGenre) {
            for (int i = 0; i < 2 && i < entry.songs.size(); i++) {
                answer.add(entry.songs.get(i).id);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}