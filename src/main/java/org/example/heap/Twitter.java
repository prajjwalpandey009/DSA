package org.example.heap;

import java.util.*;

public class Twitter {
    int counter = 0;
    Map<Integer, HashSet<Integer>> followers;
    Map<Integer, List<int[]>> tweets;

    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        counter = counter + 1;
        if (tweets.get(userId) == null) {
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{counter, tweetId});
            tweets.put(userId, list);
        } else {
            tweets.get(userId).add(new int[]{counter, tweetId});
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        int count = 10;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n[0]));
        List<Integer> list = new ArrayList<>();
        if (tweets.get(userId) != null) {
            for (int[] arr : tweets.get(userId)) {
                if (count > 0) {
                    queue.add(arr);
                    count--;
                } else {
                    queue.poll();
                    queue.add(arr);
                }
            }
        }
        if (followers.get(userId) != null) {
            for (int id : followers.get(userId)) {
                if (tweets.get(id) != null) {
                    for (int[] arr : tweets.get(id)) {
                        if (count > 0) {
                            queue.add(arr);
                            count--;
                        } else {
                            queue.poll();
                            queue.add(arr);
                        }
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            list.add(queue.poll()[1]);
        }
        Collections.reverse(list);
        return list;
    }

    public void follow(int followerId, int followeeId) {
        if (followers.get(followerId) == null) {
            HashSet<Integer> followee = new HashSet<>();
            followee.add(followeeId);
            followers.put(followerId, followee);
        } else {
            followers.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.get(followerId) == null) {
            return;
        }
        //Removal of element from hashset is O(1)
        followers.get(followerId).remove(followeeId);
    }
}
