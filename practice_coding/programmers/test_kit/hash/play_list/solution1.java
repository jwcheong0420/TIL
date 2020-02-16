package practice_coding.programmers.test_kit.hash.play_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public static int[] solution(String[] genres, int[] plays) {
        class Song {
            int id;
            int play;
            Song(int id, int play) {
                this.id = id;
                this.play = play;
            }
        }
        HashMap<String, ArrayList<Song>> songs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!songs.containsKey(genres[i])){
                songs.put(genres[i], new ArrayList<Song>());
            }
            songs.get(genres[i]).add(new Song(i, plays[i]));
        }
        ArrayList<Map.Entry<String, ArrayList<Song>>> songsList = new ArrayList<>(songs.entrySet());
        Collections.sort(songsList, new Comparator<Map.Entry<String, ArrayList<Song>>>() {
			@Override
			public int compare(Map.Entry<String, ArrayList<Song>> o1, Map.Entry<String, ArrayList<Song>> o2) {
                int o1Sum = 0, o2Sum = 0;
                for (Song song : o1.getValue()){
                    o1Sum += song.play;
                }
                for (Song song : o2.getValue()){
                    o2Sum += song.play;
                }

				return o2Sum - o1Sum;
			}
        });

       ArrayList<Integer> answerList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Song>> listPerGenre : songsList) {
            Collections.sort(listPerGenre.getValue(), new Comparator<Song>(){

                @Override
                public int compare(Song o1, Song o2) {
                    return o2.play == o1.play ? o1.id - o2.id : o2.play - o1.play;
                }

            });
            for (int i = 0; i < 2 && i < listPerGenre.getValue().size(); i++) {
                answerList.add(listPerGenre.getValue().get(i).id);
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}